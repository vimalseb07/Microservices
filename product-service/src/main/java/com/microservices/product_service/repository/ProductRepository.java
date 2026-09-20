package com.microservices.product_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.product_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    // ✅ Find by exact match
    List<Product> findByName(String name);

    // ✅ Find by partial match (LIKE %keyword%)
    List<Product> findByNameContaining(String keyword);

    // ✅ Find by stock quantity greater than a value
    List<Product> findByStockQuantityGreaterThan(int quantity);

    // ✅ Find by stock quantity less than a value
    List<Product> findByStockQuantityLessThan(int quantity);

    // ✅ Find by stock quantity between two values
    List<Product> findByStockQuantityBetween(int min, int max);

    // ✅ Find by Price greater than a value
    List<Product> findByPriceGreaterThan(int price);

    // ✅ Find by Price less than a value
    List<Product> findByPriceLessThan(int price);

    // ✅ Find by Price between two values
    List<Product> findByPriceBetween(int min, int max);

    // ✅ Find by creation date after a given timestamp
    List<Product> findByCreatedAtAfter(LocalDateTime date);

    // ✅ Find by creation date before a given timestamp
    List<Product> findByCreatedAtBefore(LocalDateTime date);

    // ✅ Find by name and stock quantity
    List<Product> findByNameAndStockQuantity(String name, int quantity);

    // ✅ Find by name ordered by updatedAt descending
    List<Product> findByNameOrderByUpdatedAtDesc(String name);

    // ✅ Count products by name
    long countByName(String name);

    // ✅ Delete products by name
    void deleteByName(String name);

}
