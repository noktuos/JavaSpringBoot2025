package com.alldata.JavaCourse2025.exceptions;/*
 * @created 12/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.DTO.MensajeExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensajeExceptionDTO> errorTiempoDeEjecucion(RuntimeException exception){
        MensajeExceptionDTO mensajeError = new MensajeExceptionDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        mensajeError.setMensaje("Error runtime: "+mensajeError.getMensaje());
        return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
    }
}
