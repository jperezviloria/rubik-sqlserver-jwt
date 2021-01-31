package com.rubikstore.rubik.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository_Test {

    @Autowired
    UserRepository userRepository;

    @Test
    void getUserByUsername(){
        String username = "eperez";
        userRepository.getUserByUsername(username);
    }

}
