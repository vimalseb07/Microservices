package com.microservices.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.repository.ProductRepository;
import com.microservices.product_service.utility.ProductResponseConverter;

@Service 
public class ProductService {
    private final ProductRepository productRepository;

    private final ProductResponseConverter productResponseConverter;

    public ProductService (ProductRepository productRepository, ProductResponseConverter productResponseConverter){
        this.productRepository = productRepository;
        this.productResponseConverter = productResponseConverter;
    }

    public List<ProductResponse> getAllProducts(ProductRequest productRequest){
        return productResponseConverter.convert(productRepository.findByName(productRequest.getName()));
   }
}
