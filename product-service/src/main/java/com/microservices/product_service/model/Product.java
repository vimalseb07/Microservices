package com.microservices.product_service.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "products")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Product implements Serializable {

    @Id    
    @GeneratedValue (strategy = GenerationType.UUID) 
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column (nullable = false)
    private Integer stockQuantity;

    @Column (nullable = false)
    private Integer price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onPrePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedAt = LocalDateTime.now();
    }


}
