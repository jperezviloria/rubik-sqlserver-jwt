package com.rubikstore.rubik.service.implementation;

import com.rubikstore.rubik.model.UserAuth;
import com.rubikstore.rubik.repository.UserAuthRepository;
import com.rubikstore.rubik.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthServiceImplementation implements UserAuthService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public Optional<UserAuth> getUserAuthByUsername(String username) {
        return userAuthRepository.getUserAuthByUsername(username);
    }
}
