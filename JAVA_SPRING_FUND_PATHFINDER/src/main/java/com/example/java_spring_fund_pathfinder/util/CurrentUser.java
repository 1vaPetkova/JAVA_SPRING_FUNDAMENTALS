package com.example.java_spring_fund_pathfinder.util;

import com.example.java_spring_fund_pathfinder.models.entities.enums.RoleType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private boolean isLoggedIn;
    private Set<RoleType> userRoles;

    public CurrentUser() {
        this.isLoggedIn = false;
        this.userRoles = new LinkedHashSet<>();
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

    public boolean isAdmin(){
        return this.userRoles.contains(RoleType.ADMIN);
    }

    public CurrentUser setUserRoles(Set<RoleType> newUserRoles) {
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }

    public boolean isLoggedIn() {
        return this.id != null;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }
}
