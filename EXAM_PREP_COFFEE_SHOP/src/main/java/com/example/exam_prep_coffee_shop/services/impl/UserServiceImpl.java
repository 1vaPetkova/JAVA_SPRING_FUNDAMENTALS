package com.example.exam_prep_coffee_shop.services.impl;

import com.example.exam_prep_coffee_shop.models.binding.UserRegisterBindingModel;
import com.example.exam_prep_coffee_shop.models.entities.User;
import com.example.exam_prep_coffee_shop.models.service.UserServiceModel;
import com.example.exam_prep_coffee_shop.repositories.UserRepository;
import com.example.exam_prep_coffee_shop.services.UserService;
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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }
}
