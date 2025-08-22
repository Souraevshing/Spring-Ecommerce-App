package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto user);
    UserDto updateUserById(Long id, UserDto user);
    String deleteUserById(Long id);

}
