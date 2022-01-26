package com.example.exam_prep_battle_ships.services.impl;

import com.example.exam_prep_battle_ships.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_battle_ships.models.entities.User;
import com.example.exam_prep_battle_ships.models.services.UserServiceModel;
import com.example.exam_prep_battle_ships.repositories.UserRepository;
import com.example.exam_prep_battle_ships.services.UserService;
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
        try {
            UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
            this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
