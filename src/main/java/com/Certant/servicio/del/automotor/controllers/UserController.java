package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.entities.User;
import com.Certant.servicio.del.automotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public void getAll(){
        userService.getAll();
    }
    @GetMapping("/{userID}")
    public void getUserByID(@PathVariable("userID") Long userID){
        userService.getById(userID);
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @DeleteMapping("/userID")
    public void deleteUser(@PathVariable("userID") Long userID){
        userService.deleteUser(userID);
    }
    @PutMapping("/{userID}")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }
}
