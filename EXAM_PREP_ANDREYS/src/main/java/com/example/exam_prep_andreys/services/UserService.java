package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.binding.UserLoginBindingModel;
import com.example.exam_prep_andreys.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_andreys.models.services.UserServiceModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);
}
