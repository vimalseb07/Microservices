package com.microservices.order_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order_service.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

    List<OrderItem> findByOrderId(String orderId);
}