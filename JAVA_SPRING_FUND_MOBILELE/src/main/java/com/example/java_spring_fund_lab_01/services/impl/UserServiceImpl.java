package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.entities.User;
import com.example.java_spring_fund_lab_01.repositories.UserRepository;
import com.example.java_spring_fund_lab_01.security.CurrentUser;
import com.example.java_spring_fund_lab_01.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean isAuthenticated(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void loginUser(String username) {
        this.currentUser
                .setAnonymous(false)
                .setName(username);
    }
}
