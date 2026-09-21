package com.microservices.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class PaymentRequest {
    private String id;
    private String orderId;
    private String userId;
    private String amount;
    private String status;
}
