package com.example.exam_prep_casebook.services;

import com.example.exam_prep_casebook.models.binding.UserLoginBindingModel;
import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_casebook.models.services.UserServiceModel;
import com.example.exam_prep_casebook.models.views.UserViewModel;

import java.util.List;

public interface UserService {
    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);

    void loginCurrentUser(UserServiceModel userServiceModel);

    void logoutCurrentUser();

    UserViewModel getLoggedInUserProfile();

    List<UserViewModel> getAllUsersThatAreNotFriends();

    UserViewModel getUserProfile(Long id);

    void addFriend(Long id);

    List<UserViewModel> getFriends();

    void unfriendUser(Long id);
}
