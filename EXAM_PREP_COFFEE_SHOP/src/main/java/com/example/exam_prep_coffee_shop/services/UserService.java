package com.example.exam_prep_coffee_shop.services;

import com.example.exam_prep_coffee_shop.models.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel userServiceModel);
}
