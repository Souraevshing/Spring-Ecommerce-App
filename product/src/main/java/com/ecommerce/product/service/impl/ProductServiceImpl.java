package com.ecommerce.product.service.impl;

import com.ecommerce.product.dto.ProductCreateRequestDto;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductEntity newProduct = productMapper.convertToCreateProductJpa(productCreateRequestDto);
        ProductEntity savedProduct = productRepository.save(newProduct);
        return productMapper.convertToDto(savedProduct);
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
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long id) {
        ProductEntity existingProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist"));
        return productMapper.convertToDto(existingProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public String deleteProductById(Long id) {
        ProductEntity existingProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product does not exist"));
        existingProduct.setActive(false);
        return "Deleted";
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> searchProducts(String searchQuery) {
        return productRepository.searchProducts(searchQuery)
                .stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

}
