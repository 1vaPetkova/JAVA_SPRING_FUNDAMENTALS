package com.example.java_spring_fund_lab_01.models.entities;



import com.example.java_spring_fund_lab_01.models.entities.enums.UserRoleEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRoleEntity {

    private Long id;
    private UserRoleEnum role;
    private Set<UserEntity> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<UserEntity> getUsers() {
        return users;
    }

    public UserRoleEntity setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }
}
