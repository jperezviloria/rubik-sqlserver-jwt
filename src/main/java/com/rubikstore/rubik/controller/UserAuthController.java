package com.rubikstore.rubik.controller;

import com.rubikstore.rubik.dto.RestResponse;
import com.rubikstore.rubik.model.AuthenticationResponse;
import com.rubikstore.rubik.model.UserAuth;
import com.rubikstore.rubik.repository.UserAuthRepository;
import com.rubikstore.rubik.security.JwtUtil;
import com.rubikstore.rubik.service.implementation.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("login")
public class UserAuthController {

    @Autowired
    JwtUtil jwtUtil;


    AuthenticationManager authenticationManager;

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    MyUserDetailsService userDetailsService;


    @GetMapping("/{username}")
    public RestResponse<Optional<UserAuth>> getUserAuthByUsername(@PathVariable String username) throws Exception{
        Optional<UserAuth> particularUser = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try{
            Optional<UserAuth> response = userAuthRepository.getUserAuthByUsername(username);
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

    @GetMapping
    public ResponseEntity<?> getUserAuthByUsername2(@RequestBody UserAuth userAuth) throws Exception{
        System.out.println("Hola");
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userAuth.getUsername(), userAuth.getPassword())
//            );
//        } catch (BadCredentialsException e){
//            throw new Exception("Incorrect username or password", e);
//        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userAuth.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
