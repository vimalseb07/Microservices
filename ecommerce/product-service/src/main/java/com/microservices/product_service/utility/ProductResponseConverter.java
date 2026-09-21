package com.microservices.product_service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservices.common.lib.utility.Converter;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.model.Product;

@Service 
public class ProductResponseConverter implements Converter<ProductResponse, Product> {

    @Override
    public ProductResponse convert(Product product) {
        return ProductResponse.builder().id(product.getId())
                                .name(product.getName())
                                .description((product.getDescription()))
                                .stockQuantity(product.getStockQuantity())
                                .price((product.getPrice()))
                                .createdAt(product.getCreatedAt())
                                .updatedAt(product.getUpdatedAt())
                                .build();
    }

    
    public List<ProductResponse> convert(List<Product> products) {
        // return products.stream().map(product -> convert(product)).collect(Collectors.toList());
        return products.stream().map(this :: convert).collect(Collectors.toList());
    }

}
