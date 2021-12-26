package com.example.java_spring_fund_lab_01.models.entities;

import com.example.java_spring_fund_lab_01.models.entities.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole {

    private Long id;
    private Role name;
    private Set<User> users;

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

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public UserRole setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
