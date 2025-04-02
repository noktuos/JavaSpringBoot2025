package com.alldata.JavaCourse2025;


import com.alldata.JavaCourse2025.controller.UsuarioController;
import com.alldata.JavaCourse2025.entities.Perfil;
import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.repositories.UsuarioRepository;
import com.alldata.JavaCourse2025.serviceImpl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private final WebApplicationContext webApplicationContext;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private final ObjectMapper objectMapper;

    @MockBean
    private UsuarioServiceImpl usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Autowired
    public IntegrationTest(WebApplicationContext webApplicationContext, ObjectMapper objectMapper, MockMvc mockMvc) {
        this.webApplicationContext = webApplicationContext;
        this.objectMapper = objectMapper;
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @WithMockUser
    @DisplayName("Flujo completo: crear producto por API y verificar en base de datos")
    void shouldCreateUserThroughAPIAndVerifyInDB() throws Exception {


        Usuario usrToCreate = new Usuario(1L,"Josue T.", "josueT@gmail.com", new Perfil(null, "Admin"), null, 28);

        Mockito.when(usuarioService.crearUsuario(any(Usuario.class)))
                .thenReturn(usrToCreate);

        MvcResult result = mockMvc.perform(post("/usuario")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usrToCreate)))
                .andExpect(status().isCreated())
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();
        Usuario usuarioCreado = objectMapper.readValue(responseContent, Usuario.class);

        Optional<Usuario> storedUsuario2 = usuarioService.obtenerUsuarioPorId(usuarioCreado.getId());
        Optional<Usuario> storedUsuario = usuarioRepository.findById(usuarioCreado.getId());
        assertTrue(storedUsuario.isPresent());
        assertEquals("Josue T.", storedUsuario.get().getNombre());
        assertEquals("josueT@gmail.com", storedUsuario.get().getCorreo());

    }

}
