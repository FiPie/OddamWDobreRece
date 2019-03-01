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
    @Column
    private String city;

    @ManyToOne
    @JoinTable(name = "charity_activity_type",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "charity_activity"))
    private CharityActivity charityActivityType;                    //jakiego rodzaju pomoc jest prowadzona przez daną Zaufaną Instytucję


    @ManyToOne
    @JoinTable(name = "charity_structure_type",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "charity_type"))
    private CharityType charityStructureType;                       //czy to Lokalna zbiórka, Fundacja czy Organizacja pozarządowa

    @ManyToMany
    @JoinTable(name = "charity_gift_type",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "gift_type_id"))
    private List<GiftType> acceptedGiftTypes;                       //jakiego rodzaju darowizny będą poszukiwane i akceptowane przez zaufaną instytucję


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

    public List<GiftType> getAcceptedGiftTypes() {
        return acceptedGiftTypes;
    }

    public void setAcceptedGiftTypes(List<GiftType> acceptedGiftTypes) {
        this.acceptedGiftTypes = acceptedGiftTypes;
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

    public CharityActivity getCharityActivityType() {
        return charityActivityType;
    }

    public void setCharityActivityType(CharityActivity charityActivityType) {
        this.charityActivityType = charityActivityType;
    }

    public CharityType getCharityStructureType() {
        return charityStructureType;
    }

    public void setCharityStructureType(CharityType charityStructureType) {
        this.charityStructureType = charityStructureType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", Charity.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "charityName='" + charityName + "'" )
                .add( "charityActivityType='" + charityActivityType + "'" )
                .add( "city='" + city + "'" )
                .add( "charityStructureType='" + charityStructureType + "'" )
                .add( "acceptedGiftTypes=" + acceptedGiftTypes )
                .toString();
    }
}
