package com.alldata.JavaCourse2025.serviceImpl;/*
 * @created 11/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostConstruct
    public void inicializar(){
        System.out.println("Usuarios inicializados");
    }

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);

    }

    public Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByCorreo(email);
    }

    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario nuevoUsuario){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                   usuario.setNombre(nuevoUsuario.getNombre());
                   usuario.setCorreo(nuevoUsuario.getCorreo());
                   usuarioRepository.save(usuario);
                   return ResponseEntity.ok(usuario);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> eliminarUsuario(Long id){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Usuario>> obtenerUsuarioPorNombreyEdad(String nombre, int edad){
        return ResponseEntity.ok(usuarioRepository.buscarPorNombreyEdad(nombre,edad));
    }
}
