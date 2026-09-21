package com.microservices.payment_service.utility;

import org.springframework.stereotype.Service;

import com.microservices.payment_service.dto.PaymentRequest;
import com.microservices.payment_service.model.Payment;

@Service 
public class PaymentModelConverter implements Converter<Payment, PaymentRequest>{

    @Override
    public Payment convert(PaymentRequest paymentRequest) {
        return Payment.builder().orderId(paymentRequest.getOrderId())
            .amount(paymentRequest.getAmount())
            .userId(paymentRequest.getUserId())
            .build();
    }

}
