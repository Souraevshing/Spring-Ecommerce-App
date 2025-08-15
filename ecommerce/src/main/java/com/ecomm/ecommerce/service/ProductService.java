package com.ecomm.ecommerce.service;

import com.ecomm.ecommerce.dto.ProductCreateRequestDto;
import com.ecomm.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductCreateRequestDto productCreateRequestDto);
    List<ProductDto> getAllProducts();
    ProductDto updateProductById(Long id, ProductDto productDto);
    ProductDto getProductById(Long id);
    String deleteProductById(Long id);

}
