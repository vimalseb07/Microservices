package com.microservices.order_service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class OrderItemResponse implements Serializable{
    private String id;
    private String productId;
    private Integer quantity;
    private Integer price;
}
