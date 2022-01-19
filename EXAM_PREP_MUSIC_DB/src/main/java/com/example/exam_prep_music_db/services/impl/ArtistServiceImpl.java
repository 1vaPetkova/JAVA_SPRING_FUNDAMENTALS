package com.example.exam_prep_music_db.services.impl;

import com.example.exam_prep_music_db.models.entities.Artist;
import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;
import com.example.exam_prep_music_db.repositories.ArtistRepository;
import com.example.exam_prep_music_db.services.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ModelMapper modelMapper) {
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initArtists() {
        if (this.artistRepository.count() == 0) {
            Arrays.stream(ArtistNameEnum.values())
                    .forEach(artistName -> this.artistRepository
                            .save(new Artist(artistName, artistName.name() + " career info")));
        }
    }

    @Override
    public Artist findArtistByName(ArtistNameEnum artist) {
        return this.artistRepository.findByName(artist).orElse(null);
    }
}
