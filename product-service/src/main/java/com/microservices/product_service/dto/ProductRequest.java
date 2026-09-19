package com.microservices.product_service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class ProductRequest implements Serializable{

    private String id;
    private String name;
    private String description;
    private Integer stockQuantity;
    
}
