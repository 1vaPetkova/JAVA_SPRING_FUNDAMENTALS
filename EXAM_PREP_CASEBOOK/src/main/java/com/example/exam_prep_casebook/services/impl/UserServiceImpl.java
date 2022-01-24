package com.example.exam_prep_casebook.services.impl;

import com.example.exam_prep_casebook.models.binding.UserLoginBindingModel;
import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_casebook.models.entities.User;
import com.example.exam_prep_casebook.models.services.UserServiceModel;
import com.example.exam_prep_casebook.models.views.UserViewModel;
import com.example.exam_prep_casebook.repositories.UserRepository;
import com.example.exam_prep_casebook.services.UserService;
import com.example.exam_prep_casebook.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public boolean registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        try {
            this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel) {
        return this.userRepository
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword())
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginCurrentUser(UserServiceModel userServiceModel) {
        this.currentUser.setUsername(userServiceModel.getUsername())
                .setId(userServiceModel.getId())
                .setGender(userServiceModel.getGender());
    }

    @Override
    public void logoutCurrentUser() {
        this.currentUser.setId(null).setUsername(null).setGender(null).setFriends(new HashSet<>());
    }

    @Override
    public UserViewModel getUserProfile(Long id) {
        UserServiceModel userServiceModel = this.userRepository.findById(id)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
        return this.modelMapper.map(userServiceModel, UserViewModel.class).setImageUrl();
    }

    @Override
    public void addFriend(Long id) {
        User userToAdd = this.userRepository
                .findById(id).orElse(null);
        this.currentUser.getFriends().add(userToAdd);
        User user = this.userRepository.findById(this.currentUser.getId()).orElse(null);
               user.getFriends().add(userToAdd);
               this.userRepository.save(user);
    }

    @Override
    public List<UserViewModel> getFriends() {
        return this.userRepository.findById(this.currentUser.getId())
                .orElse(null)
                .getFriends()
                .stream().map(friend->this.modelMapper.map(friend, UserViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void unfriendUser(Long id) {
        User userToUnfriend = this.userRepository
                .findById(id).orElse(null);
        this.currentUser.getFriends().remove(userToUnfriend);
        User user = this.userRepository.findById(this.currentUser.getId()).orElse(null);
        user.getFriends().remove(userToUnfriend);
        this.userRepository.save(user);
    }

    @Override
    public UserViewModel getLoggedInUserProfile() {
        return this.getUserProfile(this.currentUser.getId());
    }


    @Override
    public List<UserViewModel> getAllUsersThatAreNotFriends() {
        return this.userRepository.findAll()
                .stream()
                .filter(user -> !user.getUsername().equals(this.currentUser.getUsername())
                        &&
                        this.userRepository.findById(this.currentUser.getId())
                                .orElse(null)
                                .getFriends()
                                .stream()
                                .noneMatch(u -> u.getUsername().equals(user.getUsername())
                ))
                .map(user -> this.modelMapper.map(user, UserViewModel.class).setImageUrl())
                .collect(Collectors.toList());
    }

}
