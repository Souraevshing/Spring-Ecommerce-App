package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductCreateRequestDto;
import com.ecommerce.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductCreateRequestDto productCreateRequestDto);
    List<ProductDto> getAllProducts();
    ProductDto updateProductById(Long id, ProductDto productDto);
    ProductDto getProductById(Long id);
    String deleteProductById(Long id);
    List<ProductDto> searchProducts(String searchQuery);

}
