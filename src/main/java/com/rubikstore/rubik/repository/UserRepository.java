package com.rubikstore.rubik.repository;

import com.rubikstore.rubik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "EXEC getUserByUsername @username = '?1'", nativeQuery = true)
    User getUserByUsername(String username);

}
