package com.ecomm.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    private Long userId;

    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    @Digits(integer = 20, fraction = 2)
    @DecimalMin(value = "1.00", message = "Total amount must be at least 1.00")
    private BigDecimal totalAmount;

    @NotBlank(message = "Order status is required")
    private OrderStatus status = OrderStatus.PENDING;

    @NotNull(message = "Orders are required")
    private List<OrderItemDto> orders;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

}
