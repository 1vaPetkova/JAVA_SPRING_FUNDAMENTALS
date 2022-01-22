package com.example.exam_prep_casebook.services;

import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);
}
