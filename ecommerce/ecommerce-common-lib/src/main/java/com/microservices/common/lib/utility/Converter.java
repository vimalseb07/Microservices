package com.microservices.common.lib.utility;

public interface Converter<T, S> {
    T convert(S source);
} 
