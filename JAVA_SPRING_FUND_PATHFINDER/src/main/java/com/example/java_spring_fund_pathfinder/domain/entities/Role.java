package com.example.java_spring_fund_pathfinder.domain.entities;

import com.example.java_spring_fund_pathfinder.domain.entities.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleType name;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleType getName() {
        return name;
    }

    public Role setName(RoleType name) {
        this.name = name;
        return this;
    }

}
