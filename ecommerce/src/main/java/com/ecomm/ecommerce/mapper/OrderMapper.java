package com.ecomm.ecommerce.mapper;

import com.ecomm.ecommerce.dto.OrderDto;
import com.ecomm.ecommerce.dto.OrderItemDto;
import com.ecomm.ecommerce.entity.OrderEntity;
import com.ecomm.ecommerce.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "userId", target = "user.id")
    OrderEntity convertToJpa(OrderDto orderDto);

    @Mapping(source = "user.id", target = "userId")
    OrderDto convertToDto(OrderEntity order);

    @Mapping(source = "product.id", target = "productId")
    OrderItemDto orderItemToDto(OrderItemEntity entity);

    @Mapping(source = "productId", target = "product.id")
    OrderItemEntity dtoToOrderItem(OrderItemDto dto);

    void updateEntityFromDto(OrderDto src, @MappingTarget OrderEntity target);

}
