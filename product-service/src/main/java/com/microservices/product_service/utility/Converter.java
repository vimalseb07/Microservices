package com.microservices.product_service.utility;

import java.util.List;

public interface Converter<T, S> {
    T convert(S source);
    List<T> convert(List<S> source);
} 
