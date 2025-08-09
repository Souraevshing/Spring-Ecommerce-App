package com.ecomm.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address_tab")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", nullable = false, length = 30)
    private String street;

    @Column(name = "city", nullable = false, length = 10)
    private String city;

    @Column(name = "state", nullable = false, length = 10)
    private String state;

    @Column(name = "country", nullable = false, length = 10)
    private String country;

    @Column(name = "zipcode", nullable = false, length = 6)
    private String zipcode;

}
