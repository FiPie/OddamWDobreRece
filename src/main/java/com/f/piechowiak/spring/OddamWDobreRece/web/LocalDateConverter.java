package com.f.piechowiak.spring.OddamWDobreRece.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse( source, DateTimeFormatter.ISO_LOCAL_DATE );
    }

}