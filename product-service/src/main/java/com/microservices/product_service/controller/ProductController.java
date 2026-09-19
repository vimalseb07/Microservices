package com.microservices.product_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.product_service.dto.ApiResponse;
import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.service.ProductService;

@RestController 
@RequestMapping ("/api/v1/product")
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping ("/getProducts")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts (@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(ApiResponse.success(productService.getAllProducts(productRequest), "Products Retrieved")); 
    }

}
