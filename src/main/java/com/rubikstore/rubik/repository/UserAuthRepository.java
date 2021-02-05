package com.rubikstore.rubik.repository;

import com.rubikstore.rubik.model.User;
import com.rubikstore.rubik.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

//    @Query(value = "EXEC getUserAuthByUsername @username :username", nativeQuery = true)
//    Optional<UserAuth> getUserAuthByUsername(@Param("username") String username);
        @Query(value = "SELECT * FROM user_auth WHERE username = :username", nativeQuery = true)
        Optional<UserAuth> getUserAuthByUsername(@Param("username") String username);

}
