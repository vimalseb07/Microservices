package com.microservices.order_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findByUserId(String userId);

}
