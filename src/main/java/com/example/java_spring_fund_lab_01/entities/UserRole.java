package com.example.java_spring_fund_lab_01.entities;

import com.example.java_spring_fund_lab_01.entities.BaseEntity;
import com.example.java_spring_fund_lab_01.entities.enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    private Role name;

    @Enumerated(EnumType.ORDINAL)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
