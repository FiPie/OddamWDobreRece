package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.CharityActivity;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;

import java.util.List;

public class FormSearchDto {

    private List<GiftType> giftTypeList;

    private List<CharityActivity> charityActivityList;

    private String city;

    private String charityName;

    public List<GiftType> getGiftTypeList() {
        return giftTypeList;
    }

    public void setGiftTypeList(List<GiftType> giftTypeList) {
        this.giftTypeList = giftTypeList;
    }

    public List<CharityActivity> getCharityActivityList() {
        return charityActivityList;
    }

    public void setCharityActivityList(List<CharityActivity> charityActivityList) {
        this.charityActivityList = charityActivityList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }
}
