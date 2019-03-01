package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;

import javax.validation.constraints.NotNull;


public class CharityTypeDto {

    private Long id;
    @NotNull
    private String organizationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }


}
