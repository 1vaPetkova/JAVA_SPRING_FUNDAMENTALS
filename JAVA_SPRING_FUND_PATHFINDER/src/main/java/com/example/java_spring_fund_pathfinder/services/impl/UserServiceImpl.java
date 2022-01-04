package com.example.java_spring_fund_pathfinder.services.impl;

import com.example.java_spring_fund_pathfinder.models.entities.Role;
import com.example.java_spring_fund_pathfinder.models.entities.User;
import com.example.java_spring_fund_pathfinder.models.entities.enums.Level;
import com.example.java_spring_fund_pathfinder.models.service.UserServiceModel;
import com.example.java_spring_fund_pathfinder.repositories.UserRepository;
import com.example.java_spring_fund_pathfinder.services.UserService;
import com.example.java_spring_fund_pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
  //  private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, /*PasswordEncoder passwordEncoder,*/ CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
      //  this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    @Override
    public boolean isAuthenticated(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
            return user.getPassword().equals(password);
      //  return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class)
                .setLevel(Level.BEGINNER);
              //  .setPassword(this.passwordEncoder.encode(userServiceModel.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        if (isAuthenticated(username, password)) {
            User user = this.userRepository.findByUsername(username);
            return this.modelMapper.map(user, UserServiceModel.class);
        }
        return null;
    }

    @Override
    public void loginUser(Long id, String username) {
        this.currentUser
                .setId(id)
                .setUsername(username)
                .setUserRoles(this.userRepository
                        .findByUsername(username).getRoles()
                        .stream()
                        .map(Role::getRole).collect(Collectors.toSet()));
    }

    @Override
    public void logoutCurrentUser() {
        this.currentUser.setLoggedOut(true);
    }
}
