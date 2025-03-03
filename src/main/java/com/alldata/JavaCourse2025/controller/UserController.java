package com.alldata.JavaCourse2025.controller;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.model.User;
import com.alldata.JavaCourse2025.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userLst = new ArrayList<>();
            userRepo.findAll().forEach(userLst::add);
            if (userLst.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userLst, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userObj = userRepo.save(user);
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @PostMapping("/updateBookById")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User newUserData) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            User updateduserData = userData.get();
            updateduserData.setAlias(newUserData.getAlias());
            updateduserData.setUsername(newUserData.getUsername());
            User userObj = userRepo.save(updateduserData);
            return new ResponseEntity<>(userObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
