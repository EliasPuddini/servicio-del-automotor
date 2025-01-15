package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public void getAll(){
        userService.getAll();
    }
    //TODO
}
