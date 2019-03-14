package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
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

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL} , targetEntity = UserRole.class)
    private UserRole userRoles;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, targetEntity = Donation.class)
    private List<Donation> userDonationsList;

    private String uuid;
    /*@OneToMany(mappedBy = "order", cascade = {CascadeType.ALL} , targetEntity = Donation.class)
    private List<Donation> orders;*/




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

    public UserRole getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRole userRoles) {
        this.userRoles = userRoles;
    }

    public List<Donation> getUserDonationsList() { return userDonationsList; }

    public void setUserDonationsList(List<Donation> userDonationsList) { this.userDonationsList = userDonationsList; }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) { this.uuid = uuid; }

    @Override
    public String toString() {
        return new StringJoiner( ", ", User.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "firstName='" + firstName + "'" )
                .add( "lastName='" + lastName + "'" )
                .add( "email='" + email + "'" )
                .add( "password='" + password + "'" )
                .add( "enabled=" + enabled )
                .add( "userRoles=" + userRoles )
                .add( "userDonationsList=" + userDonationsList )
                .add( "uuid='" + uuid + "'" )
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
