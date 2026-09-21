package com.microservices.payment_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class PaymentResponse {
    private String id;
    private String orderId;
    private String userId;
    private String amount;
    private String transactionId;
    private String status;
    private String failureMsg;
    private LocalDateTime processedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
