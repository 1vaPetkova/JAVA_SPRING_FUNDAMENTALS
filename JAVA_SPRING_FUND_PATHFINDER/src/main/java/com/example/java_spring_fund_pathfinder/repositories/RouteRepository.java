package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.domain.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
