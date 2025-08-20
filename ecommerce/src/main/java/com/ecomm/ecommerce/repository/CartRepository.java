package com.ecomm.ecommerce.repository;

import com.ecomm.ecommerce.entity.CartEntity;
import com.ecomm.ecommerce.entity.ProductEntity;
import com.ecomm.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    CartEntity findByUserAndProduct(UserEntity userId, ProductEntity product);

    @Modifying
    @Transactional
    void deleteByUserAndProduct(UserEntity user, ProductEntity product);

    List<CartEntity> findByUser(UserEntity user);

    @Modifying
    @Transactional
    void deleteByUser(UserEntity user);

}
