package com.microservices.order_service.utility;

import org.springframework.stereotype.Service;

import com.microservices.common.lib.utility.Converter;
import com.microservices.order_service.dto.client.ProductRequest;
import com.microservices.order_service.model.OrderItem;

@Service 
public class ProductRequestConverter implements Converter<ProductRequest, OrderItem>{

    @Override
    public ProductRequest convert(OrderItem orderItem) {
        return ProductRequest.builder()
        .id(orderItem.getProductId())
        .stockQuantity(orderItem.getQuantity())
        .build();
    }

}
