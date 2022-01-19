package com.example.exam_prep_music_db.services;

import com.example.exam_prep_music_db.models.binding.UserLoginBindingModel;
import com.example.exam_prep_music_db.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_music_db.models.entities.User;
import com.example.exam_prep_music_db.models.services.UserServiceModel;

import java.util.Optional;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);

    void setCurrentUser(UserServiceModel userServiceModel);

    void logoutCurrentUser();

    Optional<User> findUserById(Long id);
}
