package com.ecomm.ecommerce.service.impl;

import com.ecomm.ecommerce.dto.UserDto;
import com.ecomm.ecommerce.entity.UserEntity;
import com.ecomm.ecommerce.mapper.UserMapper;
import com.ecomm.ecommerce.repository.UserRepository;
import com.ecomm.ecommerce.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::convertToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        UserEntity existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        return userMapper.convertToDto(existingUser);
    }

    @Override
    public UserDto createUser(UserDto user) {
        user.setId(null);
        UserEntity newUser = userMapper.convertToJpa(user);
        UserEntity savedUser = userRepository.save(newUser);
        return userMapper.convertToDto(savedUser);
    }

    @Override
    public UserDto updateUserById(Long id, UserDto user) {
        UserEntity savedUser = userRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        userMapper.updateEntityFromDto(user, savedUser);
        return userMapper.convertToDto(savedUser);
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        userRepository.deleteById(id);
        return "Deleted";
    }

}
