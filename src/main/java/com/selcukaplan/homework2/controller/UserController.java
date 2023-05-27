package com.selcukaplan.homework2.controller;


import com.selcukaplan.homework2.controller.contract.UserControllerContract;
import com.selcukaplan.homework2.dto.user.UserDTO;
import com.selcukaplan.homework2.dto.user.UserDeleteRequest;
import com.selcukaplan.homework2.dto.user.UserSaveRequest;
import com.selcukaplan.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        UserDTO userDTO = userControllerContract.saveUser(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userControllerContract.getUserById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }


    @GetMapping("/username/{username}") // Todo: is there a better approach to bind multiple methods to the same path?
    public ResponseEntity<RestResponse<UserDTO>> getUserByName(@PathVariable String username) {
        UserDTO userDTO = userControllerContract.getUSerByUsername(username);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@PathVariable Long id,@RequestBody UserSaveRequest userSaveRequest) {
        UserDTO userDTO = userControllerContract.updateUser(id,userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }


    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAllUser() {
        List<UserDTO> usersDTO = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(usersDTO));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> deleteUser(@RequestBody UserDeleteRequest userDeleteRequest) {
        userControllerContract.deleteUser(userDeleteRequest);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
