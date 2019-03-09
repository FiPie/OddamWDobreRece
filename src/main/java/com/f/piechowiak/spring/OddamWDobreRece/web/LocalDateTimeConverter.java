package com.f.piechowiak.spring.OddamWDobreRece.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String source) {
        return LocalDateTime.parse( source, DateTimeFormatter.ISO_LOCAL_DATE_TIME );
    }



}