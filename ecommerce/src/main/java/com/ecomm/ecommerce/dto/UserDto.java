package com.ecomm.ecommerce.dto;

import com.ecomm.ecommerce.validation.ValidUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be most 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be most 50 characters")
    private String lastName;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email is required")
    @Size(max = 20, message = "Email must be 20 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 12, message = "Phone number must be 12 characters")
    private String phoneNo;

    @NotBlank(message = "User role must be admin or customer")
    @ValidUser(message = "User role must be ADMIN or CUSTOMER")
    private UserRoles roles = UserRoles.CUSTOMER;

}
