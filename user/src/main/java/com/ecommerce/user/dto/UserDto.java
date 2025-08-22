package com.ecommerce.user.dto;

import com.ecommerce.user.dto.UserRoles;
import com.ecommerce.user.validation.ValidUserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be most 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be most 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Size(max = 100, message = "Email must be 100 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 12, message = "Phone number must be 12 characters")
    private String phoneNo;

    @ValidUserRole(message = "User role must be ADMIN or CUSTOMER")
    private UserRoles roles = UserRoles.CUSTOMER;

    @Valid
    private AddressDto address;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

}
