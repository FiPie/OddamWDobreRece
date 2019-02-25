package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.Gift;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrgFormDto {

    private Long id;
    @NotNull
    private String charityName;
    @NotNull
    private String city;
    @NotNull
    private String type;

    private List<Gift> acceptedGifts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Gift> getAcceptedGifts() {
        return acceptedGifts;
    }

    public void setAcceptedGifts(List<Gift> acceptedGifts) {
        this.acceptedGifts = acceptedGifts;
    }
}
