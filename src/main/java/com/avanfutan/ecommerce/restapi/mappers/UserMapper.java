package com.avanfutan.ecommerce.restapi.mappers;

import com.avanfutan.ecommerce.restapi.dtos.RegisterUserRequest;
import com.avanfutan.ecommerce.restapi.dtos.UpdateUserRequest;
import com.avanfutan.ecommerce.restapi.dtos.UserDto;
import com.avanfutan.ecommerce.restapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest registerUserRequest);
    void update(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}
