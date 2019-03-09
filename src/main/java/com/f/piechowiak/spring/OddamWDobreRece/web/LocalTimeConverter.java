package com.f.piechowiak.spring.OddamWDobreRece.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalTimeConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String source) {
        return LocalTime.parse( source, DateTimeFormatter.ISO_LOCAL_TIME );
    }

}