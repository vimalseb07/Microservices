package com.microservices.order_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.dto.OrderResponse;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.repository.OrderItemRepository;
import com.microservices.order_service.repository.OrderRepository;
import com.microservices.order_service.utility.OrderModelBuild;
import com.microservices.order_service.utility.OrderResponseBuild;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderResponseBuild orderResponseBuild;
    private final OrderModelBuild orderModelBuild;

    public List<OrderResponse> getAllOrders(){
        return orderResponseBuild.convert(orderRepository.findAll());
    }

    public OrderResponse getByOrderId(OrderRequest orderRequest){
        return orderResponseBuild.convert(orderRepository.findById(orderRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Order Not Found.")));
    }

    public List<OrderResponse> getByUserId(OrderRequest orderRequest){
        List<Order> orderList = orderRepository.findByUserId(orderRequest.getUserId());
        return orderResponseBuild.convert(orderList);
    }

    @Transactional 
    public OrderResponse placeOrder(OrderRequest orderRequest){
        Order order = orderModelBuild.convert(orderRequest);
        orderRepository.save(order);
        return orderResponseBuild.convert(order);
    }
}
