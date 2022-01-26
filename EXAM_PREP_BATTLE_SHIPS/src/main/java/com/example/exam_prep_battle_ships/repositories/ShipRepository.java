package com.example.exam_prep_battle_ships.repositories;

import com.example.exam_prep_battle_ships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
