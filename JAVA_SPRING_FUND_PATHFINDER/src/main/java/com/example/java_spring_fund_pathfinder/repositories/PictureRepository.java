package com.example.java_spring_fund_pathfinder.repositories;

import com.example.java_spring_fund_pathfinder.models.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query("SELECT p.url FROM Picture p WHERE p.id < 6")
    List<String> findAllUrls();
}

