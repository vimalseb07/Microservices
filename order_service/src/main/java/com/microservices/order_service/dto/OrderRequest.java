package com.microservices.order_service.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest implements Serializable{
    private String id;
    private String userId;
    private String shippingAddress;
    private String paymentId;
    private List<OrderItemRequest> orderItems;
}
