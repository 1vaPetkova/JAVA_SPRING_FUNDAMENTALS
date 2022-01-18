package com.example.exam_prep_andreys.services;

import com.example.exam_prep_andreys.models.binding.UserRegisterBindingModel;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);
}
