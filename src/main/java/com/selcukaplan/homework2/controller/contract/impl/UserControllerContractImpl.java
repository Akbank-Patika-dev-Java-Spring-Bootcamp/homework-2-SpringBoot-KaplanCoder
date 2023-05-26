package com.selcukaplan.homework2.controller.contract.impl;

import com.selcukaplan.homework2.controller.contract.UserControllerContract;
import com.selcukaplan.homework2.entity.User;
import com.selcukaplan.homework2.exception.BadRequest;
import com.selcukaplan.homework2.exception.NotFound;
import com.selcukaplan.homework2.mapper.UserMapper;
import com.selcukaplan.homework2.service.UserEntityService;
import com.selcukaplan.homework2.dto.user.UserDTO;
import com.selcukaplan.homework2.dto.user.UserDeleteRequest;
import com.selcukaplan.homework2.dto.user.UserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserEntityService userEntityService;


    @Override
    public List<UserDTO> findAll() {
        List<User> users = userEntityService.findAll();
        return UserMapper.INSTANCE.usersToUsersDTOList(users);
    }

    @Override
    public UserDTO getUser(Long userId) {
        Optional<User> userOptional = userEntityService.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NotFound("User with " + userId + " id is not found!");
        }
        return UserMapper.INSTANCE.userToUserDTO(userOptional.get());
    }

    @Override
    public UserDTO getUser(String username) {
        Optional<User> user = userEntityService.findByUsername(username);
        if (user.isEmpty()) {
            throw new NotFound("User with " + username + " username is not found!");
        }
        return UserMapper.INSTANCE.userToUserDTO(user.get());
    }



    @Override
    public UserDTO saveUser(UserSaveRequest saveRequest) {
        String email = saveRequest.email();
        String phoneNumber= saveRequest.phoneNumber();
        if (!userEntityService.existsByEmailOrPhoneNumber(email,phoneNumber)) {
            throw new NotFound("User with " + email + " email and " + phoneNumber + "phone number is not found!");
        }
        User newUser = UserMapper.INSTANCE.saveRequestToUser(saveRequest);
        newUser = userEntityService.save(newUser);
        return UserMapper.INSTANCE.userToUserDTO(newUser);
    }

    @Override
    public void deleteUser(UserDeleteRequest deleteRequest) {
        Optional<User> userOptional = userEntityService.findByUsername(deleteRequest.username());
        if (userOptional.isEmpty()) {
            throw new NotFound("User with " + deleteRequest.username() + " username is not found!");
        }
        User user = userOptional.get();
        if (!user.getPhoneNumber().equals(deleteRequest.phoneNumber())) {
            throw new BadRequest( deleteRequest.username() + " username is not matched  with the " + user.getPhoneNumber() + " phone number!");
        }
        userEntityService.deleteByUsernameAndPhoneNumber(deleteRequest.username(), user.getPhoneNumber());
    }

    @Override
    public UserDTO updateUser(Long userId, UserSaveRequest saveRequest) {  // Todo: user status could be updated
        Optional<User> userOptional = userEntityService.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NotFound("User with " + userId + " id is not found!");
        }
        User user = userOptional.get();
        if (saveRequest.username() != null
        && userEntityService.findByUsername(saveRequest.username()).isEmpty()) {
            user.setUsername(saveRequest.username());
        } if (saveRequest.phoneNumber() != null
                && !userEntityService.existsByEmailOrPhoneNumber("", saveRequest.phoneNumber())) {
            user.setPhoneNumber(saveRequest.phoneNumber());
        } if (saveRequest.email() != null
                && !userEntityService.existsByEmailOrPhoneNumber(saveRequest.email(),"")) {
            user.setEmail(saveRequest.email());
        }
        return UserMapper.INSTANCE.userToUserDTO(user);

    }
}
