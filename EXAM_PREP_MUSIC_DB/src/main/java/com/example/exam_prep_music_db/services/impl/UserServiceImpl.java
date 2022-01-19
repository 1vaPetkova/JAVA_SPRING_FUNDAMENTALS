package com.example.exam_prep_music_db.services.impl;

import com.example.exam_prep_music_db.models.binding.UserLoginBindingModel;
import com.example.exam_prep_music_db.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_music_db.models.entities.User;
import com.example.exam_prep_music_db.models.services.UserServiceModel;
import com.example.exam_prep_music_db.repositories.UserRepository;
import com.example.exam_prep_music_db.services.UserService;
import com.example.exam_prep_music_db.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        try {
            UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
            this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        } catch (Exception e) {
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
    public void setCurrentUser(UserServiceModel userServiceModel) {
        this.currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());
    }

    @Override
    public void logoutCurrentUser() {
        this.currentUser.setId(null).setUsername(null);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return this.userRepository.findById(id);
    }
}
