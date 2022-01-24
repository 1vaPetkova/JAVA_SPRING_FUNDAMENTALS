package com.example.exam_prep_casebook.models.services;

import com.example.exam_prep_casebook.models.entities.User;
import com.example.exam_prep_casebook.models.entities.enums.Gender;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String password;
    private Gender gender;
    private Set<User> friends;

    public UserServiceModel() {
        this.friends = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserServiceModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public UserServiceModel setFriends(Set<User> friends) {
        this.friends = friends;
        return this;
    }
}
