package com.ecomm.ecommerce.repository;

import com.ecomm.ecommerce.entity.CartEntity;
import com.ecomm.ecommerce.entity.ProductEntity;
import com.ecomm.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    CartEntity findByUserAndProduct(UserEntity userId, ProductEntity product);

}
