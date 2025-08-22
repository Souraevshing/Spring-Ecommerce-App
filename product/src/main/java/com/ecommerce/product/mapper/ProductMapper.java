package com.ecommerce.product.mapper;

import com.ecommerce.product.dto.ProductCreateRequestDto;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto convertToDto(ProductEntity product);
    ProductCreateRequestDto convertToCreateProductDto(ProductEntity product);
    ProductEntity convertToJpa(ProductDto productDto);
    ProductEntity convertToCreateProductJpa(ProductCreateRequestDto productDto);
    void updateEntityFromDto(ProductDto src, @MappingTarget ProductEntity target);

}
