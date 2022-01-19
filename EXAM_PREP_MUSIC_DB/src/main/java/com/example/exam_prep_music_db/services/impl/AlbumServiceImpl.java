package com.example.exam_prep_music_db.services.impl;

import com.example.exam_prep_music_db.models.binding.AlbumAddBindingModel;
import com.example.exam_prep_music_db.models.entities.Album;
import com.example.exam_prep_music_db.models.entities.Artist;
import com.example.exam_prep_music_db.models.entities.User;
import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;
import com.example.exam_prep_music_db.models.services.AlbumServiceModel;
import com.example.exam_prep_music_db.models.services.UserServiceModel;
import com.example.exam_prep_music_db.repositories.AlbumRepository;
import com.example.exam_prep_music_db.services.AlbumService;
import com.example.exam_prep_music_db.services.ArtistService;
import com.example.exam_prep_music_db.services.UserService;
import com.example.exam_prep_music_db.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumAddBindingModel albumAddBindingModel) {
        AlbumServiceModel albumServiceModel = this.modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);
        User user = this.userService.findUserById(this.currentUser.getId()).orElse(null);
        UserServiceModel userServiceModel = this.modelMapper.map(user, UserServiceModel.class);
        albumServiceModel.setAddedFrom(userServiceModel)
                .setArtist(this.artistService.findArtistByName(albumAddBindingModel.getArtist()));

        this.albumRepository.save(this.modelMapper.map(albumServiceModel, Album.class));
    }

    @Override
    public Long getTotalItems() {
        return this.albumRepository
                .findAll()
                .stream()
                .mapToLong(Album::getCopies).sum();
    }

}
