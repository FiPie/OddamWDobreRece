package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class DonationDto {

    private Long id;
    private Long quantity;                      //ilość worków 60L
    private List<GiftType> giftTypeList;        //Rodzaje przekazanych darów
    private User user;                          //Benefaktor
    private Charity charity;                    //Beneficjent
    private boolean giftPickedUp;               //status daru odebrany/nieodebrany
    private LocalDate pickUpDate;               //data odbioru daru
    private LocalTime pickUpHour;               //godzina odbioru
    private String city;
    private String street;
    private String postCode;
    private String phone;
    private LocalDateTime statusChangeDate;     //data zminay statusu daru odebrany/nieodebrany
    private String notes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public List<GiftType> getGiftTypeList() {
        return giftTypeList;
    }

    public void setGiftTypeList(List<GiftType> giftTypeList) {
        this.giftTypeList = giftTypeList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

    public boolean isGiftPickedUp() {
        return giftPickedUp;
    }

    public void setGiftPickedUp(boolean giftPickedUp) {
        this.giftPickedUp = giftPickedUp;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpHour() {
        return pickUpHour;
    }

    public void setPickUpHour(LocalTime pickUpHour) {
        this.pickUpHour = pickUpHour;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(LocalDateTime statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
