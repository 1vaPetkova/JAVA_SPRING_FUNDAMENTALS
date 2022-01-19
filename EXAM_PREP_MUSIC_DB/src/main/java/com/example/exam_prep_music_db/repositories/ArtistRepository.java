package com.example.exam_prep_music_db.repositories;

import com.example.exam_prep_music_db.models.entities.Artist;
import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByName(ArtistNameEnum name);
}
