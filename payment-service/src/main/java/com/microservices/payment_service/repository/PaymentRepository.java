package com.microservices.payment_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.payment_service.model.Payment;

@Repository 
public interface PaymentRepository extends JpaRepository<Payment, String>{

    Optional<Payment> findByOrderId(String orderId);
    List<Payment> findByUserId(String userId);

}
