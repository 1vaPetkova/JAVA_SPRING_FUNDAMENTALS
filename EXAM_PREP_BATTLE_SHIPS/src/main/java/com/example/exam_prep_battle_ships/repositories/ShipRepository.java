package com.example.exam_prep_battle_ships.repositories;

import com.example.exam_prep_battle_ships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("SELECT s FROM Ship s ORDER BY s.name, s.health, s.power")
    List<Ship> findAllOrderByNameHealthPower();

    Ship findByName(String name);
}
