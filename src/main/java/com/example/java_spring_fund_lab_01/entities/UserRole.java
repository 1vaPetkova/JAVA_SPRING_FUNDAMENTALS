package com.example.java_spring_fund_lab_01.entities;

import com.example.java_spring_fund_lab_01.entities.BaseEntity;
import com.example.java_spring_fund_lab_01.entities.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    private Long id;
    private Role name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.ORDINAL)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
