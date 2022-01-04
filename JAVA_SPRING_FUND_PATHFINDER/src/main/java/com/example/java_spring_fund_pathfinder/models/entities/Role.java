package com.example.java_spring_fund_pathfinder.models.entities;

import com.example.java_spring_fund_pathfinder.models.entities.enums.RoleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleType role;
    private Set<User> users;

    public Role() {
        this.users = new HashSet<>();
    }

    public Role(RoleType role) {
        this();
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    public RoleType getRole() {
        return role;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public Role setRole(RoleType role) {
        this.role = role;
        return this;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
