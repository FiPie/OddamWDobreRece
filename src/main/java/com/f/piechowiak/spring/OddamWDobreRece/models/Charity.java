package com.f.piechowiak.spring.OddamWDobreRece.models;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "charities")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String charityName;
    @NotNull
    @Column
    private String charityType;
    @Column
    private String city;

    @ManyToMany
    @JoinTable(name = "charity_gift",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "gift_id"))
    private List<Gift> acceptedGifts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charity charity = (Charity) o;
        return Objects.equals( id, charity.id );
    }



    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    public List<Gift> getAcceptedGifts() {
        return acceptedGifts;
    }

    public void setAcceptedGifts(List<Gift> acceptedGifts) {
        this.acceptedGifts = acceptedGifts;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharityType() {
        return charityType;
    }

    public void setCharityType(String charityType) {
        this.charityType = charityType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
