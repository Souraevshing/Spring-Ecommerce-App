package com.ecomm.ecommerce.controller;

import com.ecomm.ecommerce.dto.ProductCreateRequestDto;
import com.ecomm.ecommerce.dto.ProductDto;
import com.ecomm.ecommerce.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/products/create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductCreateRequestDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProductById(id, productDto), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String searchQuery) {
        return new ResponseEntity<>(productService.searchProducts(searchQuery), HttpStatus.OK);
    }

}
