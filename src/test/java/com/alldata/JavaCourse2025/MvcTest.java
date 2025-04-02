package com.alldata.JavaCourse2025;

import com.alldata.JavaCourse2025.controller.UsuarioController;
import com.alldata.JavaCourse2025.entities.Perfil;
import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.service.UsuarioService;
import com.alldata.JavaCourse2025.serviceImpl.UsuarioServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.print.attribute.standard.Media;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class MvcTest {
    @Autowired
    private MockMvc mockMvc;
    private final WebApplicationContext webApplicationContext;

    @Autowired
    private final ObjectMapper objectMapper;

    @MockBean
    private UsuarioServiceImpl usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Autowired
    public MvcTest(WebApplicationContext webApplicationContext, ObjectMapper objectMapper,MockMvc mockMvc) {
        this.webApplicationContext = webApplicationContext;
        this.objectMapper = objectMapper;
        this.mockMvc=mockMvc;
    }

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @WithMockUser
    @DisplayName("Debe insertar un usuario correctamente")
    public void testInsertUsuario() throws Exception{
        Usuario usrToCreate = new Usuario("Josue T.","josueT@gmail.com", new Perfil(null,"Admin"),null,28);
        Usuario createdUsr = new Usuario(1L,"Josue T.","josueT@gmail.com", new Perfil(null,"Admin"),null,28);

        Mockito.when(usuarioService.saveUser(usrToCreate)).thenReturn(createdUsr);

        Mockito.when(usuarioService.crearUsuario(any(Usuario.class)))
                .thenReturn(createdUsr);
        try{
            mockMvc.perform(post("/usuario")
                            .with(csrf())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(usrToCreate)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id",is(1)))
                    .andExpect(jsonPath("$.nombre",is("Josue T.")));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    @WithMockUser
    @DisplayName("Debe de traer una lista de usuarios")
    public void testGet() throws Exception {
        Usuario usuario1 = new Usuario(1L,"Josue T.","josue@gmail.com",new Perfil(1L,"admin"),null,21);
        Usuario usuario2 = new Usuario(1L,"Manuel T.","JesusMt@gmail.com",new Perfil(1L,"admin2"),null,28);

        Mockito.when(usuarioService.obtenerTodosLosUsuarios())
                .thenReturn(Arrays.asList(usuario1,usuario2));
        try{
            mockMvc.perform(get("/usuario/getAll")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].nombre", is("Josue T.")))
                    .andExpect(jsonPath("$[1].nombre", is("Manuel T.")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}
