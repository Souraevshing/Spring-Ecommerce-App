package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.OrderDto;

import java.util.Optional;

public interface OrderService {

    Optional<OrderDto> createOrder(String userId);

}
