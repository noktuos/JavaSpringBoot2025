package com.alldata.JavaCourse2025.serviceImpl;/*
 * @created 12/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Orden;
import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.repositories.OrdenRepository;
import com.alldata.JavaCourse2025.repositories.UsuarioRepository;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl {


    private final OrdenRepository ordenRepository;
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, UsuarioRepository usuarioRepository) {
        this.ordenRepository = ordenRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardarOrden(Long usuarioId, Orden orden){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            orden.setUsuario(usuario);
            usuario.getOrdenes().add(orden);
            return usuarioRepository.save(usuario);
    }

    public List<Orden> obtenerOrdenes(Long usuarioId){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return usuario.getOrdenes();
    }


}
