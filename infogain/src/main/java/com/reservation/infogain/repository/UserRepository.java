package com.reservation.infogain.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;


import com.reservation.infogain.domain.User;

@Component
public class UserRepository {
      
       Map<String,User> users = new HashMap<>();
       Long id = 1L; 
       

       public String add(User user){
           
          if(users.containsKey(user.getUsername())){
             throw new RuntimeException("User Already Exist with Given UserName");
          }
          if(user.getId() == null){
               user.setId(id++);
          }
          users.put(user.getUsername(),user);
         return "User Added Successfully";

       }

       public User getUserById(Long id) {
        for (User user : users.values()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // User not found
    }
    
}

