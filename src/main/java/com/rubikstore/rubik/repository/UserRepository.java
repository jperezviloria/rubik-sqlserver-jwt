package com.rubikstore.rubik.repository;

import com.rubikstore.rubik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query(value = "EXEC getUserByUsername @username = '?1'", nativeQuery = true)
//    User getUserByUsername(String username);
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User getUserByUsername(@Param("username") String username);

    @Query(value = "EXEC saveUser @username = :username, @password = :password, @email = :email, @age = :age", nativeQuery = true)
    void saveUser(@Param("username") String username,
                  @Param("password") String password,
                  @Param("email") String email,
                  @Param("age") int age);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsersDb();
}
