package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String firstName;
    @NotNull
    @Column
    private String lastName;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @Column
    private String password;
    @Column
    private boolean enabled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", User.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "firstName='" + firstName + "'" )
                .add( "lastName='" + lastName + "'" )
                .add( "email='" + email + "'" )
                .add( "password='" + password + "'" )
                .add( "enabled=" + enabled )
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals( id, user.id );
    }

    @Override
    public int hashCode() { return Objects.hash( id ); }
}
