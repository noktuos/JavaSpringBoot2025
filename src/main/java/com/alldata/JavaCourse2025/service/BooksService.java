package com.alldata.JavaCourse2025.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BooksService {
    public ResponseEntity<?> transformar(@RequestBody String jsonObject);
}
