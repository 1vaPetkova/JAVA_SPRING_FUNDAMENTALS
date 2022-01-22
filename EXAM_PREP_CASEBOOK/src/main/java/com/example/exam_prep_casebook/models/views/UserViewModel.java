package com.example.exam_prep_casebook.models.views;

import com.example.exam_prep_casebook.models.entities.enums.Gender;

public class UserViewModel {

    private Long id;
    private String username;
    private Gender gender;
    private String imageUrl;

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserViewModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserViewModel setImageUrl() {
        this.imageUrl = String.format("png/%s.png",this.gender.name().toLowerCase());
        return this;
    }
}
