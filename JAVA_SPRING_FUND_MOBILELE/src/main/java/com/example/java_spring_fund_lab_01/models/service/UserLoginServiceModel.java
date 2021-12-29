package com.example.java_spring_fund_lab_01.models.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginServiceModel {

    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 3)
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
