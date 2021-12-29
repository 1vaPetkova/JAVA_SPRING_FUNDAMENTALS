package com.example.java_spring_fund_lab_01.security;

import com.example.java_spring_fund_lab_01.models.entities.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String name = ANONYMOUS;
    private boolean isAnonymous = true;
    private Set<RoleEnum> userRoles = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public CurrentUser setUserRoles(Set<RoleEnum> newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }

    public boolean isAdmin(){
        return this.userRoles.contains(RoleEnum.ADMIN);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn() {
        return !this.isAnonymous;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }
}
