package com.example.java_spring_fund_lab_01.models.service;

import com.example.java_spring_fund_lab_01.security.CurrentUser;

public class UserLoginServiceModel {
    private String username;
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
