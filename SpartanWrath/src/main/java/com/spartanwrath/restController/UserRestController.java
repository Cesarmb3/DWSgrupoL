package com.spartanwrath.restController;


import com.spartanwrath.exceptions.NoUsers;
import com.spartanwrath.model.User;
import com.spartanwrath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserRestController {

    @Autowired
    private UserService userServ ;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            List<User> users = userServ.GetAllUsers();
            return ResponseEntity.ok().body(users);
        } catch (NoUsers noUsers){
            return ResponseEntity.notFound().build();
        }
    }
}

// Arreglar lista de productos a usuario y viceversa