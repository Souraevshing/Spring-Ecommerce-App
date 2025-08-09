package com.ecomm.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 30, message = "Street must be most 30 characters")
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 10, message = "City must be most 10 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 10, message = "State must be most 10 characters")
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 10, message = "Country must be most 10 characters")
    private String country;

    @NotBlank(message = "Zipcode is required")
    @Size(max = 6, message = "Zipcode must be most 6 characters")
    private String zipcode;

}
