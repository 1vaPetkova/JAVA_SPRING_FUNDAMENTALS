package com.example.java_spring_fund_lab_01.services;

public interface UserService {
    boolean isAuthenticated(String username, String password);

    void loginUser(String username);
}
