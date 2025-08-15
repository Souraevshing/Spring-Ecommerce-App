package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto user);
    UserDto updateUserById(Long id, UserDto user);
    String deleteUserById(Long id);

}
