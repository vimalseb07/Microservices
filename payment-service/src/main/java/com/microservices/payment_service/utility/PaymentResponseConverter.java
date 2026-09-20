package com.microservices.payment_service.utility;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.payment_service.dto.PaymentResponse;
import com.microservices.payment_service.model.Payment;

@Service 
public class PaymentResponseConverter implements Converter<PaymentResponse, Payment>{

    @Override
    public PaymentResponse convert(Payment payment) {
        return PaymentResponse.builder()
                .amount(payment.getAmount())
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .status(payment.getStatus())
                .userId(payment.getUserId())
                .transactionId(payment.getTransactionId())
                .failureMsg(payment.getFailureMsg())
                .processedAt(payment.getProcessedAt())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }

    public List<PaymentResponse> convert(List<Payment> paymentList){
        return paymentList.stream().map(this :: convert).toList();
    }

}
