package com.ecomm.ecommerce.entity;

import com.ecomm.ecommerce.dto.UserRoles;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_tab")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 20, unique = true)
    private String email;

    @Column(name = "phone_no", nullable = false, length = 12)
    private String phoneNo;

    @Column(name = "user_role", nullable = false)
    private UserRoles roles = UserRoles.CUSTOMER;

}
