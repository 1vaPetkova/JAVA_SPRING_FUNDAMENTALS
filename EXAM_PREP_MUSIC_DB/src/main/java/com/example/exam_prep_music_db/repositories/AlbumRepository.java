package com.example.exam_prep_music_db.repositories;

import com.example.exam_prep_music_db.models.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAllByOrderByCopiesDesc();
}
