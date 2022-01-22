package com.example.exam_prep_casebook.models.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters!")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3, max = 15, message = "Password must be between 3 and 15 characters!")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
