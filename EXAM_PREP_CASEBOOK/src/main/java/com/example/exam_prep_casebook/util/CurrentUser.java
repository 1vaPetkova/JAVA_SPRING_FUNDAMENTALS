package com.example.exam_prep_casebook.util;

import com.example.exam_prep_casebook.models.entities.enums.Gender;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private Long id;
    private String username;
    private Gender gender;
    private String imageUrl;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public CurrentUser setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CurrentUser setImageUrl() {
        this.imageUrl = String.format("png/%s.png",this.gender.name().toLowerCase());
        return this;
    }
}
