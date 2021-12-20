package com.example.java_spring_fund_pathfinder.domain.entities;

import com.example.java_spring_fund_pathfinder.domain.entities.enums.Level;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private Role role;
    private Level level;

    public User() {
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @ManyToOne
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
    @Column
    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }
}
