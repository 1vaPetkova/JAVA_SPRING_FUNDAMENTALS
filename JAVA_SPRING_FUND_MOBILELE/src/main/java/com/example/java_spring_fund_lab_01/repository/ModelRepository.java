package com.example.java_spring_fund_lab_01.repository;


import com.example.java_spring_fund_lab_01.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    ModelEntity findByName(String model);
}
