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
public class OrderItemRequest implements Serializable{
    private String productId;
    private Integer quantity;
    private Integer price;

    /* *
    *   Note: Without Serializable, your DTO works for REST but breaks in caching, clustering, or messaging scenarios. Adding it is lightweight and future‑proof.
    * */
}
