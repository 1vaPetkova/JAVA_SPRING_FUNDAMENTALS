package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
