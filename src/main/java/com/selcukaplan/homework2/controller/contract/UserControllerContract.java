package com.selcukaplan.homework2.controller.contract;

import com.selcukaplan.homework2.dto.user.UserDTO;
import com.selcukaplan.homework2.dto.user.UserDeleteRequest;
import com.selcukaplan.homework2.dto.user.UserSaveRequest;
import java.util.List;


public interface UserControllerContract {

    List<UserDTO> findAll();

    UserDTO getUser(Long userId);

    UserDTO getUser(String username);

    UserDTO saveUser(UserSaveRequest saveRequest);

    void deleteUser(UserDeleteRequest deleteRequest);

    UserDTO updateUser(Long userId, UserSaveRequest saveRequest);


}
