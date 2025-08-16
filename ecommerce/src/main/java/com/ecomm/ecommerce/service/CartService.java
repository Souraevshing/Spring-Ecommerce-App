package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.CartDto;

public interface CartService {

    Boolean addToCart(String userId, CartDto cartDto);

}
