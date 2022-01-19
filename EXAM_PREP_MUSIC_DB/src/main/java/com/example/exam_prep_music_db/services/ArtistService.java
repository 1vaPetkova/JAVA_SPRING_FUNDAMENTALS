package com.example.exam_prep_music_db.services;

import com.example.exam_prep_music_db.models.entities.Artist;
import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();

    Artist findArtistByName(ArtistNameEnum artist);
}
