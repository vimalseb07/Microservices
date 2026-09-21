package com.microservices.product_service.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.common.lib.utility.Converter;
import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.model.Product;

@Service
public class ProductBuilderFromProductRequest implements Converter<Product, ProductRequest>{

    @Override
    public Product convert(ProductRequest productRequest) {
        return Product.builder().name(productRequest.getName())
                                .stockQuantity((productRequest.getStockQuantity()))
                                .price(productRequest.getPrice())
                                .description(productRequest.getDescription())
                                .build();
    }

    public List<Product> convert(List<ProductRequest> ProductRequest) {
        return new ArrayList<>();
    }

}
