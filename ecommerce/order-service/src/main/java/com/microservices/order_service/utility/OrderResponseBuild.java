package com.microservices.order_service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservices.order_service.dto.OrderItemResponse;
import com.microservices.order_service.dto.OrderResponse;
import com.microservices.order_service.model.Order;

@Service 
public class OrderResponseBuild implements Converter<OrderResponse,Order>{

    @Override
    public OrderResponse convert(Order order) {
        List<OrderItemResponse> orderItemResponseList = order.getOrderItems().stream().map(item -> 
             OrderItemResponse.builder().id(item.getId())
             .productId(item.getProductId())
             .quantity(item.getQuantity())
             .price(item.getPrice())
             .build()
        ).collect((Collectors.toList()));

        return OrderResponse.builder().id(order.getId())
                .userId(order.getUserId())
                .totalAmount(order.getTotalAmount())
                .shippingAddress(order.getShippingAddress())
                .paymentId(order.getPaymentId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt()) 
                .orderItems(orderItemResponseList)       
                .build();
    }

    public List<OrderResponse> convert(List<Order> orderList){
        return orderList.stream().map(this :: convert).toList();
    }

}
