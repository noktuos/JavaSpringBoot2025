package com.alldata.JavaCourse2025.controller;

import com.alldata.JavaCourse2025.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("dev")
@RequestMapping("/dev")
public class DevController {

    @Value("${username}")
    private String username;

    @PostMapping
    public ResponseEntity<?> profile(@RequestBody User username){
        return new ResponseEntity("Profile of dev active: "+ username.getUsername().length(),HttpStatus.OK);
    }

}
