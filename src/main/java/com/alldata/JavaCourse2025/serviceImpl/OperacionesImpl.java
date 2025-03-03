package com.alldata.JavaCourse2025.serviceImpl;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.alldata.JavaCourse2025.service.OperacionesService;
import org.springframework.http.ResponseEntity;
@Service
public class OperacionesImpl implements OperacionesService {

    @PostConstruct
    public void inicializar(){
        System.out.println("Servicio de Operaciones: Inicializado");
    }

    @Override
    public ResponseEntity<?> sumar(int fistN, int secondN) {

        return null;
    }

    @Override
    public ResponseEntity<?> restar(int fistN, int secondN) {
        return null;
    }

    @Override
    public ResponseEntity<?> multiplicar(int fistN, int secondN) {
        return null;
    }

    @Override
    public ResponseEntity<?> dividir(int fistN, int secondN) {
        if(fistN <= 0 || secondN <= 0){
            return ResponseEntity.internalServerError().body("No se permiten datos no positivos o iguales a 0");
        }else{
            Integer resultado = fistN / secondN;
            return ResponseEntity.ok(resultado);
        }
    }
}
