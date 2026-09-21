package com.microservices.payment_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.lib.dto.ApiResponse;
import com.microservices.payment_service.dto.PaymentRequest;
import com.microservices.payment_service.dto.PaymentResponse;
import com.microservices.payment_service.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/payment")
@RequiredArgsConstructor 
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping ("/getByUserId")
    public ResponseEntity<ApiResponse<List<PaymentResponse>>> getPaymentsByUserId(@RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(ApiResponse.success(paymentService.getPaymentsByUser(paymentRequest), "Payments from User"));

    }

    @PostMapping ("/createPayment")
    public ResponseEntity<ApiResponse<PaymentResponse>> createPayment(@RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(ApiResponse.success(paymentService.newPayment(paymentRequest), "Payment Successfully Created."));
    }

}
