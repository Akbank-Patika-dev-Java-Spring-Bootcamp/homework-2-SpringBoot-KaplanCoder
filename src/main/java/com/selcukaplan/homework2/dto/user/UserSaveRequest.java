package com.selcukaplan.homework2.dto.user;

import com.selcukaplan.homework2.entity.UserType;

public record UserSaveRequest(String username,
                              String email,
                              String phoneNumber,
                              UserType status) {
}
