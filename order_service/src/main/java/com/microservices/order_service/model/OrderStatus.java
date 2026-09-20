package com.microservices.order_service.model;

public enum OrderStatus {
    PENDING("PENDING"), 
    CONFIRMED("CONFIRMED"), 
    PROCESSING("PROCESSING"), 
    SHIPPED("SHIPPED"), 
    DELIVERED("DELIVERED"), 
    CANCELLED("CANCELLED"), 
    REFUNDED("REFUNDED"),;

    private final String statusCode;

    OrderStatus(String statusCode){
        this.statusCode = statusCode;
    }

    public String getStatus(){
        return this.statusCode;
    }

}
