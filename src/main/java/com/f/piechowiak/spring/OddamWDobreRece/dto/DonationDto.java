package com.f.piechowiak.spring.OddamWDobreRece.dto;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.CharityActivity;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class DonationDto {

    private Long id;
    private Long quantity;                      //ilość worków 60L
    private LocalDateTime creationDate;

    private List<GiftType> giftTypeList;        //Rodzaje przekazanych darów
    private User user;                          //Benefaktor
    private Charity charity;                    //Beneficjent

    private boolean giftPickedUp;               //status daru odebrany/nieodebrany
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Future
    private LocalDate pickUpDate;               //data odbioru darowizny
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpHour;               //godzina odbioru darowizny
    private String city;                        //adres odbioru darowizny (miasto)
    private String street;                      //adres odbioru darowizny (ulica)
    private String postCode;                    //adres odbioru darowizny (kod pocztowy)
    private String phone;                       //numer telefonu kontaktowego z userem
    private LocalDateTime statusChangeDate;     //data zmiany statusu daru odebrany/nieodebrany
    private String notes;                       //nota opcjonalna, uwagi dla kuriera/obiorcy darowizny



    //auxiliary search data (won't persist)

    private String selectedCharityCity;
    private List<CharityActivity> selectedCharityActivityList;
    private String selectedCharityName;

    public String getSelectedCharityCity() { return selectedCharityCity; }
    public void setSelectedCharityCity(String selectedCharityCity) { this.selectedCharityCity = selectedCharityCity; }
    public List<CharityActivity> getSelectedCharityActivityList() { return selectedCharityActivityList; }
    public void setSelectedCharityActivityList(List<CharityActivity> selectedCharityActivityList) { this.selectedCharityActivityList = selectedCharityActivityList; }
    public String getSelectedCharityName() { return selectedCharityName; }
    public void setSelectedCharityName(String selectedCharityName) { this.selectedCharityName = selectedCharityName; }

    //end of auxiliary data



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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
