package com.microservices.order_service.utility;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.common.lib.utility.Converter;
import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.model.OrderItem;

@Service 
public class OrderModelBuild implements Converter<Order, OrderRequest>{

    @Override
    public Order convert(OrderRequest orderRequest) {
        List<OrderItem> orderItemList = orderRequest.getOrderItems().stream().map(item -> 
            OrderItem.builder().price(item.getPrice())
            .productId(item.getProductId())
            .quantity(item.getQuantity()).build()
        ).toList();

        Integer totalAmount = orderItemList.stream().map(OrderItem :: getItemTotal).reduce(0, Integer :: sum);

        Order order = Order.builder().userId(orderRequest.getUserId())
                            .shippingAddress(orderRequest.getShippingAddress())
                            .paymentId(orderRequest.getPaymentId())
                            .totalAmount(totalAmount)
                            .orderItems(orderItemList)
                            .build();
        orderItemList.forEach(item -> item.setOrder(order));

        return order;
    }

}
