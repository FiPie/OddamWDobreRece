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

    @NotNull    //to ma być @ManyToOne
    @Column
    private String charityActivityType;                 //jakiego rodzaju pomoc jest prowadzona przez daną Zaufaną Instytucję
    @Column
    private String city;


    @Column     ////to ma być @ManyToOne i stowrzyć osobną tabelę
    private String charityStructureType;        //czy to Lokalna zbiórka, Fundacja czy Organizacja pozarządowa

    @ManyToMany
    @JoinTable(name = "charity_gift_type",
            joinColumns = @JoinColumn(name = "charity_id"),
            inverseJoinColumns = @JoinColumn(name = "gift_type_id"))
    private List<Gift> acceptedGiftTypes;


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

    public List<Gift> getAcceptedGiftTypes() {
        return acceptedGiftTypes;
    }

    public void setAcceptedGiftTypes(List<Gift> acceptedGiftTypes) {
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

    public String getCharityActivityType() {
        return charityActivityType;
    }

    public void setCharityActivityType(String charityActivityType) {
        this.charityActivityType = charityActivityType;
    }

    public String getCharityStructureType() {
        return charityStructureType;
    }

    public void setCharityStructureType(String charityStructureType) { this.charityStructureType = charityStructureType; }

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
