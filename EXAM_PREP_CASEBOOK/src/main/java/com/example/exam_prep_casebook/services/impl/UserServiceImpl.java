package com.example.exam_prep_casebook.services.impl;

import com.example.exam_prep_casebook.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_casebook.models.entities.User;
import com.example.exam_prep_casebook.models.services.UserServiceModel;
import com.example.exam_prep_casebook.repositories.UserRepository;
import com.example.exam_prep_casebook.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
}
