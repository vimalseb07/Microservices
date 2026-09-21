package com.microservices.order_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.common.lib.dto.ApiResponse;
import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.dto.OrderResponse;
import com.microservices.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/order")
@RequiredArgsConstructor 
public class OrderController {

    public final OrderService orderService;

    @GetMapping ("/getByUserId")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrdersByUserId(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(ApiResponse.success(orderService.getByUserId(orderRequest), "Orders from User"));

    }

    @PostMapping ("/placeOrder")
    public ResponseEntity<ApiResponse<OrderResponse>> placeOrder(@RequestBody OrderRequest orderRequest){
        try{
            return ResponseEntity.ok(ApiResponse.success(orderService.placeOrder(orderRequest), "Order Successfully placed."));
        } catch (Exception e){
            return ResponseEntity.ok(ApiResponse.fail(null, e.getLocalizedMessage())); 
        }
    }

}
