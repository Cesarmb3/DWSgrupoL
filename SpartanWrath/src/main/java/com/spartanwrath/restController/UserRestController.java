package com.spartanwrath.restController;


import com.spartanwrath.exceptions.InvalidUser;
import com.spartanwrath.exceptions.NoUsers;
import com.spartanwrath.exceptions.UserAlreadyRegister;
import com.spartanwrath.exceptions.UserNotFound;
import com.spartanwrath.model.User;
import com.spartanwrath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        try {
            User user = userServ.getUserbyUsername(username);
            return ResponseEntity.ok().body(user);
        } catch (UserNotFound userNotFound){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestBody User user){
        try {
            userServ.add(user);
            return ResponseEntity.ok().body(user);
        } catch (UserAlreadyRegister | InvalidUser e) {
            return ResponseEntity.notFound().build();
        }
    }
}


// Arreglar lista de productos a usuario y viceversa