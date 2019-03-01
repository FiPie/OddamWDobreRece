package com.f.piechowiak.spring.OddamWDobreRece.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class CharityActivityDto {

    private Long id;

    @NotNull
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
}
