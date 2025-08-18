package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.CartDto;
import com.ecomm.ecommerce.entity.CartEntity;

import java.util.List;

public interface CartService {

    Boolean addToCart(String userId, CartDto cartDto);
    String removeFromCart(String userId, Long productId);
    List<CartEntity> getCartItems(String userId);

}
