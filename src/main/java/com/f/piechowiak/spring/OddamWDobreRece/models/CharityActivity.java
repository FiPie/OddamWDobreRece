package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "charity_activities")
public class CharityActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "charity_activity")
    private String organizationActivity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationActivity() {
        return organizationActivity;
    }

    public void setOrganizationActivity(String organizationActivity) {
        this.organizationActivity = organizationActivity;
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", CharityActivity.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "organizationActivity='" + organizationActivity + "'" )
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharityActivity that = (CharityActivity) o;
        return Objects.equals( id, that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
