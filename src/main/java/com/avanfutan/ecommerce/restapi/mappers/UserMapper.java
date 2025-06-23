package com.avanfutan.ecommerce.restapi.mappers;

import com.avanfutan.ecommerce.restapi.dtos.UserDto;
import com.avanfutan.ecommerce.restapi.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
