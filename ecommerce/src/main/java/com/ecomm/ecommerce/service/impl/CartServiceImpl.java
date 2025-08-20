package com.ecomm.ecommerce.service.impl;

import com.ecomm.ecommerce.dto.CartDto;
import com.ecomm.ecommerce.entity.CartEntity;
import com.ecomm.ecommerce.entity.ProductEntity;
import com.ecomm.ecommerce.entity.UserEntity;
import com.ecomm.ecommerce.repository.CartRepository;
import com.ecomm.ecommerce.repository.ProductRepository;
import com.ecomm.ecommerce.repository.UserRepository;
import com.ecomm.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public Boolean addToCart(String userId, CartDto cartDto) {
        Optional<ProductEntity> products = productRepository.findById(cartDto.getProductId());
        if (products.isEmpty()) {
            return false;
        }

        ProductEntity allProducts = products.get();
        if(allProducts.getStockQuantity() < cartDto.getQuantity()) {
            return false;
        }

        Optional<UserEntity> users = userRepository.findById(Long.valueOf(userId));
        if(users.isEmpty()) {
            return false;
        }

        UserEntity allUsers = users.get();
        CartEntity existingCartItems = cartRepository.findByUserAndProduct(allUsers, allProducts);
        if (existingCartItems != null) {
            // update cart if no items in cart
            existingCartItems.setQuantity(existingCartItems.getQuantity() + cartDto.getQuantity());
            existingCartItems.setPrice(allProducts.getPrice().multiply(BigDecimal.valueOf(existingCartItems.getQuantity())));
            cartRepository.save(existingCartItems);
        } else {
            // create cart with new products
            CartEntity cartItems = new CartEntity();
            cartItems.setUser(allUsers);
            cartItems.setProduct(allProducts);
            cartItems.setQuantity(cartDto.getQuantity());
            cartItems.setPrice(allProducts.getPrice().multiply(BigDecimal.valueOf(cartDto.getQuantity())));
            cartRepository.save(cartItems);
        }

        return true;
    }

    @Override
    @Transactional
    public String removeFromCart(String userId, Long productId) {
        Optional<ProductEntity> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            return "No products found";
        }

        Optional<UserEntity> userOpt = userRepository.findById(Long.valueOf(userId));
        if (userOpt.isEmpty()) {
            return "No users found";
        }

        // Use flatMap and return directly
        return userOpt.flatMap(user ->
                productOpt.map(product -> {
                    cartRepository.deleteByUserAndProduct(user, product);
                    return "Products deleted from cart";
                })
        ).orElse("Products not deleted from the cart");
    }

    @Transactional
    @Override
    public List<CartEntity> getCartItems(String userId) {
        UserEntity user = userRepository.findById(Long.valueOf(userId))
                .orElse(null);
        if (user == null) {
            return List.of();
        }
        return cartRepository.findByUser(user);
    }

    @Transactional
    @Override
    public void clearCart(String userId) {
        userRepository.findById(Long.valueOf(userId))
                .ifPresent(cartRepository::deleteByUser);
    }

}
