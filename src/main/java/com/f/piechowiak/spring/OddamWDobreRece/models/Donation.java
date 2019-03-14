package com.f.piechowiak.spring.OddamWDobreRece.models;


import org.apache.tomcat.jni.Time;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column                         //ilość worków 60L
    private Long quantity;

    @ManyToMany                     //Rodzaje przekazanych darów
    @JoinTable(name = "donation_gift_type_id",
    joinColumns = @JoinColumn(name = "donation_id"),
    inverseJoinColumns = @JoinColumn(name = "gift_type_id"))
    private List<GiftType> giftTypeList;

    @ManyToOne /*(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)*/    //Darczyńca
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne                      //Beneficjent
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @Column
    private boolean giftPickedUp;   //status daru odebrany/nieodebrany
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate pickUpDate;   //data odbioru daru
    @Column
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpHour;   //godzina odbioru
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String postCode;
    @Column
    private String phone;
    @Column
    private LocalDateTime statusChangeDate;         //data zminay statusu daru odebrany/nieodebrany
    @Column
    private String notes;

    @Override
    public String toString() {
        return new StringJoiner( ", ", Donation.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "quantity=" + quantity )
                .add( "giftTypeList=" + giftTypeList )
                /*.add( "user=" + user )*/          //wiesza się z jakiegoś powodu...
                .add( "charity=" + charity )
                .add( "giftPickedUp=" + giftPickedUp )
                .add( "pickUpDate=" + pickUpDate )
                .add( "city='" + city + "'" )
                .add( "street='" + street + "'" )
                .add( "postCode='" + postCode + "'" )
                .add( "phone='" + phone + "'" )
                .add( "statusChangeDate=" + statusChangeDate )
                .add( "pickUpHour=" + pickUpHour )
                .add( "notes='" + notes + "'" )
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals( id, donation.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }


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
