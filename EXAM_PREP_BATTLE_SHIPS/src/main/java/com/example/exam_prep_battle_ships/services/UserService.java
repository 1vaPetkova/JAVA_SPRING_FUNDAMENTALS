package com.example.exam_prep_battle_ships.services;

import com.example.exam_prep_battle_ships.models.binding.UserLoginBindingModel;
import com.example.exam_prep_battle_ships.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_battle_ships.models.entities.User;
import com.example.exam_prep_battle_ships.models.services.UserServiceModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);

    void loginCurrentUser(UserServiceModel userServiceModel);

    void logoutCurrentUser();

    User findUserById(Long id);
}
