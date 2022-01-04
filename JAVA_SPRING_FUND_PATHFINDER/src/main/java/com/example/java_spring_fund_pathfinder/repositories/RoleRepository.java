package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.models.entities.Role;
import com.example.java_spring_fund_pathfinder.models.entities.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(RoleType roleType);
}
