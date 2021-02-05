package com.rubikstore.rubik.service;

import com.rubikstore.rubik.model.UserAuth;

import java.util.Optional;

public interface UserAuthService {

    Optional<UserAuth> getUserAuthByUsername(String username);
}
