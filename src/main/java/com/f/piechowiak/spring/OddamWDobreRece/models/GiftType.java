package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "gift_types")
public class GiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String giftType;



    @Override
    public String toString() {
        return new StringJoiner( ", ", GiftType.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "giftType='" + giftType + "'" )
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftType giftType = (GiftType) o;
        return Objects.equals( id, giftType.id );
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

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }
}
