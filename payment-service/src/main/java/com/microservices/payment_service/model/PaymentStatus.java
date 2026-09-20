package com.microservices.payment_service.model;

public enum PaymentStatus {

    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    REFUNDED("REFUNDED")
    ;

    private final String statusCode;

    PaymentStatus(String statusCode){
        this.statusCode = statusCode;
    }

    public String getPaymentStatus(){
        return statusCode;
    }

}
