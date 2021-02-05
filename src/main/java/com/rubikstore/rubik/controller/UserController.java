package com.rubikstore.rubik.controller;

import com.rubikstore.rubik.dto.RestResponse;
import com.rubikstore.rubik.model.User;
import com.rubikstore.rubik.service.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    /*
    @PostMapping
    public User getUserByUsername(@RequestBody String username){
        return userServiceImplementation.getUserByUsername(username);
    }
     */


    @PostMapping("/save")
    public RestResponse<String> saveUser(@RequestBody User user) throws Exception{
        String particularUser = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            String response = userServiceImplementation.saveUser(user);
            if(response != null){
                httpStatus = HttpStatus.OK;
                particularUser = response;
            }else{
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception e){
            e.getCause();
        }
        return new RestResponse<>(httpStatus, particularUser);
    }


    @GetMapping("/all")
    public RestResponse<List<User>> getAllUsers() throws Exception{
        List<User> particularUser = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            List<User> response = userServiceImplementation.getAllUsers();
            if(!response.isEmpty()){
                httpStatus = HttpStatus.OK;
                particularUser = response;
            }else{
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception e){
            e.getCause();
        }
        return new RestResponse<>(httpStatus, particularUser);
    }

    @GetMapping("/{username}")
    public RestResponse<User> getUserByUsername(@PathVariable String username) throws Exception{
        User particularUser = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            User response = userServiceImplementation.getUserByUsername(username);
            if(response != null){
                httpStatus = HttpStatus.OK;
                particularUser = response;
            }else{
                httpStatus = HttpStatus.NO_CONTENT;
            }
        }catch (Exception e){
            e.getCause();
        }
        return new RestResponse<>(httpStatus, particularUser);
    }
}
