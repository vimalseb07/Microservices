package com.microservices.payment_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.payment_service.dto.PaymentRequest;
import com.microservices.payment_service.dto.PaymentResponse;
import com.microservices.payment_service.model.Payment;
import com.microservices.payment_service.repository.PaymentRepository;
import com.microservices.payment_service.utility.PaymentModelConverter;
import com.microservices.payment_service.utility.PaymentResponseConverter;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class PaymentService {

    private final PaymentModelConverter paymentModelConverter;
    private final PaymentRepository paymentRepository;
    private final PaymentResponseConverter paymentResponseConverter;

    public List<PaymentResponse> getPaymentsByUser(PaymentRequest paymentRequest){
        List<Payment> payment = paymentRepository.findByUserId(paymentRequest.getUserId());
        return paymentResponseConverter.convert(payment);
    }

    @Transactional 
    public PaymentResponse newPayment(PaymentRequest paymentRequest){
        Payment payment = paymentModelConverter.convert(paymentRequest);
        paymentRepository.save(payment);
        return paymentResponseConverter.convert(payment);
    }

}
