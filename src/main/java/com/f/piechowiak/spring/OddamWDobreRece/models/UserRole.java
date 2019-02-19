package com.f.piechowiak.spring.OddamWDobreRece.models;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roles")
    private String role;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return new StringJoiner( ", ", UserRole.class.getSimpleName() + "[", "]" )
                .add( "id=" + id )
                .add( "role='" + role + "'" )
                .add( "user=" + user )
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
