package com.alldata.JavaCourse2025.controller;/*
 * @created 12/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Orden;
import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.repositories.UsuarioRepository;
import com.alldata.JavaCourse2025.serviceImpl.OrdenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orden")
public class OrdenController {

    private final OrdenServiceImpl ordenService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public OrdenController(OrdenServiceImpl ordenService,
                           UsuarioRepository usuarioRepository) {
        this.ordenService = ordenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("{idUsuario}")
    public ResponseEntity<Usuario> agregarOrden(@PathVariable Long idUsuario, @RequestBody Orden orden){
        return ResponseEntity.ok(ordenService.guardarOrden(idUsuario, orden));
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<List<Orden>> obtenerOrdenes(@PathVariable Long idUsuario){
        return ResponseEntity.ok(ordenService.obtenerOrdenes(idUsuario));

    }

}
