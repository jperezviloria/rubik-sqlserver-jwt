package com.rubikstore.rubik.controller;

import com.rubikstore.rubik.model.User;
import com.rubikstore.rubik.service.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @PostMapping
    public User getUserByUsername(@RequestBody String username){
        return userServiceImplementation.getUserByUsername(username);
    }

}
