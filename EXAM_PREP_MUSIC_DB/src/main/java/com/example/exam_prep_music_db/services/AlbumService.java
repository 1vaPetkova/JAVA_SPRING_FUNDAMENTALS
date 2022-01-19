package com.example.exam_prep_music_db.services;

import com.example.exam_prep_music_db.models.binding.AlbumAddBindingModel;
import com.example.exam_prep_music_db.models.views.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumAddBindingModel albumAddBindingModel);

    Long getTotalItems();

    List<AlbumViewModel> getAlbums();

    void deleteAlbum(Long id);
}
