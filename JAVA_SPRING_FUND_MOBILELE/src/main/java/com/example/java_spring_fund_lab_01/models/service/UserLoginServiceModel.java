package com.example.java_spring_fund_lab_01.models.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginServiceModel {


    private String username;

    private String rawPassword;

    @NotBlank
    @Size(min = 2)
    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    @Size(min = 3)
    public String getRawPassword() {
        return rawPassword;
    }

    public UserLoginServiceModel setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
        return this;
    }
}
