package com.ecomm.ecommerce.service.impl;

import com.ecomm.ecommerce.dto.OrderDto;
import com.ecomm.ecommerce.dto.OrderStatus;
import com.ecomm.ecommerce.entity.CartEntity;
import com.ecomm.ecommerce.entity.OrderEntity;
import com.ecomm.ecommerce.entity.OrderItemEntity;
import com.ecomm.ecommerce.entity.UserEntity;
import com.ecomm.ecommerce.mapper.OrderMapper;
import com.ecomm.ecommerce.repository.CartRepository;
import com.ecomm.ecommerce.repository.OrderRepository;
import com.ecomm.ecommerce.repository.UserRepository;
import com.ecomm.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartServiceImpl cartService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public Optional<OrderDto> createOrder(String userId) {
        Optional<UserEntity> existingUser = userRepository.findById(Long.valueOf(userId));
        if (existingUser.isEmpty()) {
            return Optional.empty();
        }
        UserEntity user = existingUser.get();

        List<CartEntity> cartItems = cartService.getCartItems(userId);
        if (cartItems.isEmpty()) {
            return Optional.empty();
        }

        BigDecimal totalPrice = cartItems.stream()
                .map(CartEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        OrderEntity order = new OrderEntity();
        order.setUser(user);
        order.setStatus(OrderStatus.CONFIRMED);
        order.setTotalAmount(totalPrice);

        List<OrderItemEntity> orderItems = cartItems.stream()
                .map(items -> new OrderItemEntity(
                        null,
                        items.getProduct(),
                        items.getQuantity(),
                        items.getPrice(),
                        order
                ))
                .toList();
        order.setOrders(orderItems);

        OrderEntity savedOrder = orderRepository.save(order);
        cartRepository.deleteByUser(user);
        return Optional.of(orderMapper.convertToDto(savedOrder));
    }


}
