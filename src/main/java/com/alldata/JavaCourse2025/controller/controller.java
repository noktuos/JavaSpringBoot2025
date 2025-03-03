package com.alldata.JavaCourse2025.controller;/*
 * @created 28/02/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "operaciones")
public class controller {
    private OperacionesService operacionesService;

    public controller(OperacionesService operacionesService) {
        this.operacionesService = operacionesService;
    }

    @PostMapping("/dividir")
    public ResponseEntity<?> dividir(){
       return operacionesService.dividir(6, 3);
    }

    @PostMapping("/saludo2")
    public String cambiarSaludos(){
        return "Hola mundo desde un POST";
    }
}
