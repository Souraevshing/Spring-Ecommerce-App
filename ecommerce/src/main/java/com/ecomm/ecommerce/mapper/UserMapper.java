package com.ecomm.ecommerce.mapper;

import com.ecomm.ecommerce.dto.UserDto;
import com.ecomm.ecommerce.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto convertToDto(UserEntity user);
    UserEntity convertToJpa(UserDto user);
    void updateEntityFromDto(UserDto src, @MappingTarget UserEntity target);

}
