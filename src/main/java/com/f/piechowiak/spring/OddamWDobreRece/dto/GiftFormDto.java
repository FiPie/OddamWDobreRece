package com.f.piechowiak.spring.OddamWDobreRece.dto;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

public class GiftFormDto {


    private Long id;
    @NotNull
    private String giftType;


    public Long getId() { return id; }

    public void setId(Long id) {this.id = id; }

    public String getGiftType() { return giftType; }

    public void setGiftType(String giftType) { this.giftType = giftType; }
}
