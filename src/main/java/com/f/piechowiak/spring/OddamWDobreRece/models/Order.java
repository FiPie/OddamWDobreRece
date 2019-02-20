package com.f.piechowiak.spring.OddamWDobreRece.models;


import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column                         //ilość worków 60L
    private Long quantity;

    @ManyToOne                      //Rodzaj daru
    @JoinColumn(name = "gift_id")
    private Gift gift;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)    //Darczyńca
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne                      //Beneficjent
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String postCode;
    @Column
    private String phone;
    @Column
    private String date;
    @Column
    private String hour;
    @Column
    private String notes;

    @Override
    public String toString() {
        return new StringJoiner( ", ", Order.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "quantity=" + quantity )
                .add( "gift=" + gift )
                .add( "user=" + user )
                .add( "charity=" + charity )
                .add( "city='" + city + "'" )
                .add( "street='" + street + "'" )
                .add( "postCode='" + postCode + "'" )
                .add( "phone='" + phone + "'" )
                .add( "date='" + date + "'" )
                .add( "hour='" + hour + "'" )
                .add( "notes='" + notes + "'" )
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals( id, order.id );
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

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
