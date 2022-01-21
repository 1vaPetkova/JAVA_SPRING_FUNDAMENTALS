package com.example.exam_prep_casebook.repositories;

import com.example.exam_prep_casebook.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
