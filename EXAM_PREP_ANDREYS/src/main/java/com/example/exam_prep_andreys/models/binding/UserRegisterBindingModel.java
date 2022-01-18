package com.example.exam_prep_andreys.models.binding;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private BigDecimal budget;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 2, message = "Username must be more than two characters!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Email(message = "Please enter valid email!")
    @NotBlank(message = "Email cannot be empty!")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @DecimalMin(value = "0", message = "Budget must be more or equal to 0!")
    @NotNull
    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 2, message = "Password must be more than two characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 2, message = "Password must be more than two characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
