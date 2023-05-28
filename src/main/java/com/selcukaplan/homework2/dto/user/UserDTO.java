package com.selcukaplan.homework2.dto.user;

import com.selcukaplan.homework2.entity.UserType;

import java.time.LocalDateTime;

public record UserDTO(Long id,
                      String username,
                      String email,
                      String phoneNumber,
                      UserType status,
                      LocalDateTime createDate,
                      LocalDateTime updateDate) {

}
