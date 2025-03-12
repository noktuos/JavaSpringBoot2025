package com.alldata.JavaCourse2025.controller;/*
 * @created 11/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.serviceImpl.UsuarioServiceImpl;
import org.apache.coyote.Response;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario (@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id){
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.actualizarUsuario(id,usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminarUsuario(Long id){
        return  usuarioService.eliminarUsuario(id);
    }

    @GetMapping("nombre/{nombre}/edad/{edad}")
    public ResponseEntity<?> getUsuariosPorNombreyEdad(@PathVariable String nombre, @PathVariable int edad){
        return usuarioService.obtenerUsuarioPorNombreyEdad(nombre, edad);
    }
}

