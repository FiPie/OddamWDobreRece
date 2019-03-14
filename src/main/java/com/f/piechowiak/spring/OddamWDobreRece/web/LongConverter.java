package com.f.piechowiak.spring.OddamWDobreRece.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LongConverter implements Converter<String, Long> {

    @Override
    public Long convert(String source) {return Long.parseLong( source );}

}
