package com.example.exam_prep_battle_ships.repositories;

import com.example.exam_prep_battle_ships.models.entities.Category;
import com.example.exam_prep_battle_ships.models.entities.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryEnum name);
}
