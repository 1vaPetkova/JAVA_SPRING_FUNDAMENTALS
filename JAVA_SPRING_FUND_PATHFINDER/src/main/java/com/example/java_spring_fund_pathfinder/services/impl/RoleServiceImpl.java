package com.example.java_spring_fund_pathfinder.services.impl;

import com.example.java_spring_fund_pathfinder.models.entities.Role;
import com.example.java_spring_fund_pathfinder.models.entities.enums.RoleType;
import com.example.java_spring_fund_pathfinder.repositories.RoleRepository;
import com.example.java_spring_fund_pathfinder.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(RoleType roleType) {
        return this.roleRepository.findByRole(roleType);
    }
}
