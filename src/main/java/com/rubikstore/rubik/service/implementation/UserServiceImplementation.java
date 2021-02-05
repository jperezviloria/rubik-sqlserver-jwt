package com.rubikstore.rubik.service.implementation;

import com.rubikstore.rubik.model.User;
import com.rubikstore.rubik.repository.UserRepository;
import com.rubikstore.rubik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsersDb();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public String saveUser(User user) {
        userRepository.saveUser(
                user.getUsername(),
                user.getPassword(),
                user.getEmailUser(),
                user.getAgeUser());
        return "user was saved";
    }
}
