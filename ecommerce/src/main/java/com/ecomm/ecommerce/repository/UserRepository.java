package com.ecomm.ecommerce.repository;

import com.ecomm.ecommerce.dto.UserDto;
import com.ecomm.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByEmail(String email);

}
