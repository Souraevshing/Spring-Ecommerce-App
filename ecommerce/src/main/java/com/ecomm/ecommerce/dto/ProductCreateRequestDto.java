package com.ecomm.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateRequestDto {

    @NotBlank(message = "Product name is required")
    @Size(max = 50, message = "Product name must be most 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 50, message = "Description must be most 50 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Digits(integer = 20, fraction = 2)
    @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private Integer stockQuantity;

    @NotBlank(message = "Category is required")
    @Size(max = 50, message = "Category must be at most 50 characters")
    private String category;

    @NotBlank(message = "Image URL is required")
    @Size(max = 300, message = "Image URL must be at most 300 characters")
    private String imageUrl;
}
