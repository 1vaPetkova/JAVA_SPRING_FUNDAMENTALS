package com.example.exam_prep_casebook.services;

import com.example.exam_prep_casebook.models.binding.UserLoginBindingModel;
import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_casebook.models.services.UserServiceModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);
}
