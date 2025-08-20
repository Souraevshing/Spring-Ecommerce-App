package com.ecomm.ecommerce.controller;

import com.ecomm.ecommerce.dto.OrderDto;
import com.ecomm.ecommerce.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping("/orders/create")
    public ResponseEntity<OrderDto> createOrder(@RequestHeader("X-User-ID") String userId) {
        return orderService.createOrder(userId)
                .map(order -> new ResponseEntity<>(order, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
