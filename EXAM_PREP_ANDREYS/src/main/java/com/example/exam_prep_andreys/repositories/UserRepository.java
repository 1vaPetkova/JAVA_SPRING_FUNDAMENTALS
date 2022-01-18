package com.example.exam_prep_andreys.repositories;

import com.example.exam_prep_andreys.models.entities.User;
import com.example.exam_prep_andreys.models.services.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
