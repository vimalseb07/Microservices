package com.microservices.order_service.dto.client;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class ProductResponse implements Serializable {

    private String id;
    private String name;
    private String description;
    private Integer stockQuantity;
    private Integer price;
    private Boolean inStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
