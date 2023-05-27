package com.selcukaplan.homework2.dao;

import com.selcukaplan.homework2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    @Query(value = "SELECT u  FROM User u where u.username  = :username")
    Optional<User> findByUsername(@Param("username") String username);

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

    void deleteByUsernameAndPhoneNumber(String username,String phoneNumber);


}
