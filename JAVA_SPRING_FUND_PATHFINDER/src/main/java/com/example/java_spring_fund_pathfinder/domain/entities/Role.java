package com.example.java_spring_fund_pathfinder.domain.entities;

import com.example.java_spring_fund_pathfinder.domain.entities.enums.RoleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleType name;
    private Set<User> users;

    public Role() {
        this.users = new HashSet<>();
    }

    @Enumerated(EnumType.STRING)
    public RoleType getName() {
        return name;
    }

    public Role setName(RoleType name) {
        this.name = name;
        return this;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
