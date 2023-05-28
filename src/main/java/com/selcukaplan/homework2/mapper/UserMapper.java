package com.selcukaplan.homework2.mapper;


import com.selcukaplan.homework2.dto.user.UserDTO;
import com.selcukaplan.homework2.dto.user.UserSaveRequest;
import com.selcukaplan.homework2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createDate",source = "user.baseAdditionalFields.createDate")
    @Mapping(target = "updateDate",source = "user.baseAdditionalFields.updateDate")
    UserDTO userToUserDTO(User user);


    User userDTOtoUser(UserDTO userDTO);

    User saveRequestToUser(UserSaveRequest userSaveRequest);

    List<UserDTO> usersToUsersDTOList(List<User> users);



}
