package com.microservices.product_service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class ProductRequest implements Serializable{
    /* Data Transfer Object */
    private String id;
    private String name;
    private String description;
    private Integer stockQuantity;
    private Integer price;
    private Integer stockUpdateFactor;

}
