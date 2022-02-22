package com.example.java_spring_fund_lab_01.service;


import com.example.java_spring_fund_lab_01.model.service.UserRegistrationServiceModel;

public interface UserService {

  void initializeUsersAndRoles();

  void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

  boolean isUserNameFree(String username);
}
