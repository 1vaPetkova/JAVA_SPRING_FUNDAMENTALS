package com.example.java_spring_fund_pathfinder.services;

import com.example.java_spring_fund_pathfinder.models.entities.User;
import com.example.java_spring_fund_pathfinder.models.service.UserServiceModel;

public interface UserService {

    boolean isAuthenticated(String username, String password);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);


    void logoutCurrentUser();

    UserServiceModel findById(Long id);

    boolean doesNameExist(String username);

    User findCurrentUser();
}
