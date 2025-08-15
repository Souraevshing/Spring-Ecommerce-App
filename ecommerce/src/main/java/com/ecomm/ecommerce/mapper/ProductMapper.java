package com.ecomm.ecommerce.mapper;

import com.ecomm.ecommerce.dto.ProductCreateRequestDto;
import com.ecomm.ecommerce.dto.ProductDto;
import com.ecomm.ecommerce.entity.ProductEntity;
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
