package com.example.exam_prep_battle_ships.services;

import com.example.exam_prep_battle_ships.models.binding.UserRegisterBindingModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);
}
