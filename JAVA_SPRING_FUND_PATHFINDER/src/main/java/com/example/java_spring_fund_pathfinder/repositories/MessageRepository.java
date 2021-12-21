package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.domain.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
