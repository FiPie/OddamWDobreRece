package com.f.piechowiak.spring.OddamWDobreRece.models;

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
    private String type;
    @Column
    private String city;

    @ManyToOne                          //Czy może to powinna być relacja ManyToMany???
    @JoinColumn(name = "gift_id")
    private Gift acceptedGifts;


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

    @Override
    public String toString() {
        return new StringJoiner( ", ", Charity.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "charityName='" + charityName + "'" )
                .add( "type='" + type + "'" )
                .add( "city='" + city + "'" )
                .add( "acceptedGifts=" + acceptedGifts )
                .toString();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gift getAcceptedGifts() {
        return acceptedGifts;
    }

    public void setAcceptedGifts(Gift acceptedGifts) {
        this.acceptedGifts = acceptedGifts;
    }
}
