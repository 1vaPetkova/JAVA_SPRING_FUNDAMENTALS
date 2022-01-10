package com.example.exam_prep_coffee_shop.repositories;

import com.example.exam_prep_coffee_shop.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
