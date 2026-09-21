package com.microservices.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.model.Product;
import com.microservices.product_service.repository.ProductRepository;
import com.microservices.product_service.utility.ProductBuilderFromProductRequest;
import com.microservices.product_service.utility.ProductResponseConverter;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductResponseConverter productResponseConverter;
    private final ProductBuilderFromProductRequest productBuilderFromProductRequest;

    public List<ProductResponse> getAllProducts(ProductRequest productRequest){
        return productResponseConverter.convert(productRepository.findByNameContaining(productRequest.getName()));
    }

    public List<ProductResponse> getAllProductsInRange(int min, int max){
        return productResponseConverter.convert(productRepository.findByPriceBetween(min, max));
    }
 

    @Transactional 
    public ProductResponse createProduct(ProductRequest productRequest){
        Product newProduct = productBuilderFromProductRequest.convert(productRequest);
        productRepository.save(newProduct);
        return productResponseConverter.convert(newProduct);
    }

    @Transactional 
    public ProductResponse updateStock(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Product Not Found."));
        Integer updatedStock = Integer.sum(product.getStockQuantity(), productRequest.getStockUpdateFactor());
        product.setStockQuantity(updatedStock);
        productRepository.save(product);
        return productResponseConverter.convert(product);
    }

    public List<ProductResponse> availableProducts(List<ProductRequest> productRequests){
        List<Product> availableList = productRequests.stream().map(productRequest -> {
            return productRepository.findByIdAndStockQuantityGreaterThanEqual(productRequest.getId(), productRequest.getStockQuantity())
            .orElse(Product.builder().name(productRequest.getId()).stockQuantity(0).build());
        }).toList();
        return productResponseConverter.convert(availableList);
    }
}
