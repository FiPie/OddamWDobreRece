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
    private String charityActivityType;

    private List<Gift> acceptedGiftTypes;

    private String charityStructureType;

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

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

    public String getCharityActivityType() { return charityActivityType; }
    public void setCharityActivityType(String charityActivityType) { this.charityActivityType = charityActivityType; }

    public List<Gift> getAcceptedGiftTypes() { return acceptedGiftTypes; }
    public void setAcceptedGiftTypes(List<Gift> acceptedGiftTypes) { this.acceptedGiftTypes = acceptedGiftTypes; }

    public String getCharityStructureType() { return charityStructureType; }
    public void setCharityStructureType(String charityStructureType) { this.charityStructureType = charityStructureType; }
}
