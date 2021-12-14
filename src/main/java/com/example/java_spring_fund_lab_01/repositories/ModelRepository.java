package com.example.java_spring_fund_lab_01.repositories;

import com.example.java_spring_fund_lab_01.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
