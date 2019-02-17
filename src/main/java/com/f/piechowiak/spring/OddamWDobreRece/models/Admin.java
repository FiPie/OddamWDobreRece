package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins")
public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals( o )) return false;
        Admin admin = (Admin) o;
        return Objects.equals( id, admin.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode(), id );
    }
}
