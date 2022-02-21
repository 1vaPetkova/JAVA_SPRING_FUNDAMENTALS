package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);
}
