package com.ecomm.ecommerce.service.impl;

import com.ecomm.ecommerce.dto.ProductCreateRequestDto;
import com.ecomm.ecommerce.dto.ProductDto;
import com.ecomm.ecommerce.entity.ProductEntity;
import com.ecomm.ecommerce.mapper.ProductMapper;
import com.ecomm.ecommerce.repository.ProductRepository;
import com.ecomm.ecommerce.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductEntity newProduct = productMapper.convertToCreateProductJpa(productCreateRequestDto);
        productRepository.save(newProduct);
        return productMapper.convertToDto(newProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> allProducts = productRepository
                .findByActiveTrue();

        return allProducts
                .stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProductById(Long id, ProductDto productDto) {
        ProductEntity savedProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist"));
        return productMapper.convertToDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity existingProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist"));
        return productMapper.convertToDto(existingProduct);
    }

    @Override
    public String deleteProductById(Long id) {
        ProductEntity existingProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist"));
        existingProduct.setActive(false);
        return "Deleted";
    }

    @Override
    public List<ProductDto> searchProducts(String searchQuery) {
        return productRepository.searchProducts(searchQuery)
                .stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

}
