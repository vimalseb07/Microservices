package com.microservices.payment_service.utility;

public interface Converter<T, S> {
    T convert(S source);
} 
