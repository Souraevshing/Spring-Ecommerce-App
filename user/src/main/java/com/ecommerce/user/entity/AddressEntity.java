package com.ecommerce.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address_tab")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
