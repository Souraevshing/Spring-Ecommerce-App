package com.ecomm.ecommerce.repository;

import com.ecomm.ecommerce.dto.UserDto;
import com.ecomm.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
