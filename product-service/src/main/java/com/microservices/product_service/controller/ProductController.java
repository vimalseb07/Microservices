package com.microservices.product_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping ("/getProductsInRange")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProductsInRange (@RequestParam int min,
                        @RequestParam int max
    ) {
        return ResponseEntity.ok(ApiResponse.success(productService.getAllProductsInRange(min, max), "Products Retrieved")); 
    }

    @PostMapping ("/createProduct")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(ApiResponse.success(productService.createProduct(productRequest), "Product Created.")); 
    }

    @PostMapping ("/updateStock")
    public ResponseEntity<ApiResponse<ProductResponse>> updateStock(@RequestBody ProductRequest productRequest) {
        try{
            ProductResponse productResponse = productService.updateStock(productRequest);
            return ResponseEntity.ok(ApiResponse.success(productResponse, "Product Stock Updated Successfully.")); 
        } catch (Exception e){
            return ResponseEntity.ok(ApiResponse.fail(null, e.getLocalizedMessage())); 
        }
        
        
    }

}
