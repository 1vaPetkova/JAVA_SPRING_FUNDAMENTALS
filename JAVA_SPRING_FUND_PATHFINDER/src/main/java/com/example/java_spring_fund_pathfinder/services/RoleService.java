package com.example.java_spring_fund_pathfinder.services;

import com.example.java_spring_fund_pathfinder.models.entities.Role;
import com.example.java_spring_fund_pathfinder.models.entities.enums.RoleType;

public interface RoleService {
    Role getRole(RoleType roleType);
}
