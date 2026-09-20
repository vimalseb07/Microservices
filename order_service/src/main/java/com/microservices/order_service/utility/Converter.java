package com.microservices.order_service.utility;

public interface Converter<T, S> {
    T convert(S source);
} 
