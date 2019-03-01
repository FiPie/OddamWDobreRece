package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.CharityActivity;
import com.f.piechowiak.spring.OddamWDobreRece.models.CharityType;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrgFormDto {

    private Long id;
    @NotNull
    private String charityName;
    @NotNull
    private String city;
    @NotNull
    private CharityActivity charityActivityType;

    private List<GiftType> acceptedGiftTypes;

    private CharityType charityStructureType;

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

    public CharityActivity getCharityActivityType() {
        return charityActivityType;
    }

    public void setCharityActivityType(CharityActivity charityActivityType) {
        this.charityActivityType = charityActivityType;
    }

    public List<GiftType> getAcceptedGiftTypes() { return acceptedGiftTypes; }
    public void setAcceptedGiftTypes(List<GiftType> acceptedGiftTypes) { this.acceptedGiftTypes = acceptedGiftTypes; }

    public CharityType getCharityStructureType() { return charityStructureType; }
    public void setCharityStructureType(CharityType charityStructureType) { this.charityStructureType = charityStructureType; }
}
