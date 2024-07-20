package com.reservation.infogain.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.infogain.domain.User;
import com.reservation.infogain.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
       
     
    @Autowired
    private UserService userService;


    @PostMapping("add")
    public ResponseEntity<?> addUser(@RequestParam String username, @RequestParam String password){
         
        String res = userService.add(username,password);
         return ResponseEntity.ok().body("User created Successfully");
         
}   

 @GetMapping
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
        
      
}
    
