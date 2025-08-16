package com.ecomm.ecommerce.controller;

import com.ecomm.ecommerce.dto.CartDto;
import com.ecomm.ecommerce.service.impl.CartServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final CartServiceImpl cartService;

    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestHeader("X-User-ID") String userId, @Valid @RequestBody CartDto cartDto) {
        if(!cartService.addToCart(userId, cartDto)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Product out of stock or invalid or user not found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product added to cart");
    }

}
