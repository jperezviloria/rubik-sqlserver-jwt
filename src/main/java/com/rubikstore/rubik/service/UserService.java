package com.rubikstore.rubik.service;

import com.rubikstore.rubik.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    String saveUser(User user);


}
