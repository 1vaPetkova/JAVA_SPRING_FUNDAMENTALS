package com.example.exam_prep_casebook.models.binding;

import com.example.exam_prep_casebook.models.entities.enums.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private Gender gender;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3, max = 15, message = "Password must be between 3 and 15 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3, max = 15, message = "Password must be between 3 and 15 characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotNull(message = "Please enter gender!")
    public Gender getGender() {
        return gender;
    }

    public UserRegisterBindingModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
