package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.entities.User;
import com.Certant.servicio.del.automotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> getAll(){
        try{
            userService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body("Users found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found");
        }
    }
    @GetMapping("/{userID}")
    public ResponseEntity<String> getUserByID(@PathVariable("userID") Long userID){

        try{
            userService.getById(userID);
            return ResponseEntity.status(HttpStatus.OK).body("User found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){

        try{
            userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("User saved successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not saved");
        }
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable("userID") Long userID){

        try{
            userService.deleteUser(userID);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not deleted");
        }
    }
    @PutMapping("/{userID}")
    public ResponseEntity<?> updateUser(@PathVariable("userID") Long userID, @RequestBody @Validated User user) {
        try {
            userService.updateUser(userID, user);
            return ResponseEntity.status(HttpStatus.OK).body("User with ID: "+ userID+" updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error updating user with ID: " + userID);
        }
    }
}
