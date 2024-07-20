package com.reservation.infogain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.infogain.domain.User;
import com.reservation.infogain.services.UserService;

@RestController
public class LoginController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User pricipalUser=null;
        if(userService.getUsers().get(username) != null){
            pricipalUser = userService.getUsers().get(username);
        } 
        String storedPassword =null;
        if (pricipalUser.getPassword()!=null){
             storedPassword = pricipalUser.getPassword();
        } 

        if (storedPassword != null && storedPassword.equals(password)) {
            return ResponseEntity.ok("Login successful");
        } 
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
