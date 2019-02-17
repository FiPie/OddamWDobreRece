package com.f.piechowiak.spring.OddamWDobreRece.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginFormDto {

    @NotNull @Email
    private String email;
    @NotNull
    private String password;



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
}
