package com.microservices.order_service.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.common.lib.dto.ApiResponse;
import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.dto.OrderResponse;
import com.microservices.order_service.dto.client.ProductRequest;
import com.microservices.order_service.dto.client.ProductResponse;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.repository.OrderRepository;
import com.microservices.order_service.utility.OrderModelBuild;
import com.microservices.order_service.utility.OrderResponseBuild;
import com.microservices.order_service.utility.ProductRequestConverter;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final OrderResponseBuild orderResponseBuild;
    private final OrderModelBuild orderModelBuild;
    private final ProductRequestConverter productRequestConverter;

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
        if(!checkOrderItemStock(order))
            throw new IllegalArgumentException("Items not in stock. Modify Order Items.");
        orderRepository.save(order);
        return orderResponseBuild.convert(order);
    }

    private Boolean checkOrderItemStock(Order order){
        List<ProductRequest> productList = order.getOrderItems().stream().map(productRequestConverter :: convert).toList();
        return checkStockWebClientCall(productList);
    }

    private Boolean checkStockWebClientCall(List<ProductRequest> productList){
        List<ProductResponse> productResponses = webClientBuilder.build().post()
            .uri("http://product-service/api/v1/product/checkStock")
            .bodyValue(productList)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<ApiResponse<List<ProductResponse>>>() {}) 
            .map(ApiResponse::getData) 
            .block();

        return productResponses.stream().allMatch(ProductResponse :: getInStock) ;

    }
}
