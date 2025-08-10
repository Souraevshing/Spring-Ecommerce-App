package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsers();
    public UserDto getUserById(Long id);
    public UserDto createUser(UserDto user);
    public UserDto updateUserById(Long id, UserDto user);
    public String deleteUserById(Long id);

}
