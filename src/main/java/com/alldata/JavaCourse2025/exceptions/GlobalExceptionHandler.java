package com.alldata.JavaCourse2025.exceptions;

import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
import org.h2.index.Index;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Profile("dev")

public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> errorApuntadorNull(NullPointerException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<?> errorIndex(IndexOutOfBoundsException exception){
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> numberFormatException(NumberFormatException exception){
        return ResponseEntity.internalServerError().body("Number Format Exception"+ exception.getMessage());
    }

}
