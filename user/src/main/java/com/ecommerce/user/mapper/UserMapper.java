package com.ecommerce.user.mapper;

import com.ecommerce.user.dto.UserDto;
import com.ecommerce.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto convertToDto(UserEntity user);
    UserEntity convertToJpa(UserDto user);
    void updateEntityFromDto(UserDto src, @MappingTarget UserEntity target);

}
