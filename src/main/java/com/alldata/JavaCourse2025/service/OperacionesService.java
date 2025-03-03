package com.alldata.JavaCourse2025.service;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface OperacionesService {

    public ResponseEntity<?> sumar(int fistN, int secondN);
    public ResponseEntity<?> restar(int fistN, int secondN);
    public ResponseEntity<?> multiplicar(int fistN, int secondN);
    public ResponseEntity<?> dividir(int fistN, int secondN);
}
