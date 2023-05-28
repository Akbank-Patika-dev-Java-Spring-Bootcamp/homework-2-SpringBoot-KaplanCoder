package com.selcukaplan.homework2.service;

import com.selcukaplan.homework2.dao.UserRepository;
import com.selcukaplan.homework2.entity.User;
import com.selcukaplan.homework2.general.BaseEntityService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {


    public UserEntityService(UserRepository repository) {
        super(repository);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);

    }

    public boolean existsByEmailOrPhoneNumber(String email, String phoneNumber) {
        return repository.existsByEmailOrPhoneNumber(email,phoneNumber);
    }

    public void deleteByUsernameAndPhoneNumber(String username,String phoneNumber) {
        repository.deleteByUsernameAndPhoneNumber(username,phoneNumber);
    }



}
