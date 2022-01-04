package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.models.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
