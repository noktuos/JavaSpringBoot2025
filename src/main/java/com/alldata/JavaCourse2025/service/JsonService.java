package com.alldata.JavaCourse2025.service;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface JsonService {
    public ResponseEntity<?> transformar(@RequestBody String jsonObject);


}
