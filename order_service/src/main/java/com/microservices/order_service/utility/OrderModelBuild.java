package com.microservices.order_service.utility;

import org.springframework.stereotype.Service;

import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.model.Order;

@Service 
public class OrderModelBuild implements Converter<Order, OrderRequest>{

    @Override
    public Order convert(OrderRequest orderRequest) {
        return Order.builder().userId(orderRequest.getUserId())
                            .shippingAddress(orderRequest.getShippingAddress())
                            .paymentId(orderRequest.getPaymentId())
                            .build();
    }

}
