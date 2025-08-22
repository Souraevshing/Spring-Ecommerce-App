package com.ecommerce.product.repository;

import com.ecommerce.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByActiveTrue();

    @Query("SELECT p FROM ProductEntity p WHERE p.active = true AND p.stockQuantity > 0 AND LOWER(p.name) LIKE LOWER(CONCAT('%', :searchQuery, '%'))")
    List<ProductEntity> searchProducts(@Param("searchQuery") String searchQuery);

}
