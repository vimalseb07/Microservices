package com.microservices.order_service.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String userId;
    private Integer totalAmount;
    private String shippingAddress;
    private String paymentId;
    private List<OrderItemRequest> orderItems;
}
