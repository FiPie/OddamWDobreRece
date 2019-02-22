package com.f.piechowiak.spring.OddamWDobreRece.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginFormDto {

    @NotNull @Email
    private String email;
    @NotNull @NotBlank
    private String password;
    /*@NotNull @AssertTrue
    private boolean enabled;


    public boolean isEnabled() {
        return enabled; }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled; }*/

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
