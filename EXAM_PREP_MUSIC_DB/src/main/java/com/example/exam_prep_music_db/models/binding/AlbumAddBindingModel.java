package com.example.exam_prep_music_db.models.binding;

import com.example.exam_prep_music_db.models.entities.Artist;
import com.example.exam_prep_music_db.models.entities.enums.GengeEnum;
import com.example.exam_prep_music_db.models.services.UserServiceModel;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GengeEnum genre;
    private Artist artist;
    private UserServiceModel addedFrom;

    public AlbumAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 10, message = "Name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank
    @Size(min = 5, message = "Image Url length must be minimum 5 characters!")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotBlank
    @Size(min = 5, message = "Description length must be minimum 5 characters!")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    @Min(value = 10, message = "Copies must be more than or equal to 10!")
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @NotNull
    @DecimalMin(value = "0", message = "Price must be a positive number!")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PastOrPresent(message = "Release date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull(message = "You must select genre!")
    public GengeEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GengeEnum genre) {
        this.genre = genre;
        return this;
    }
    @NotNull(message = "You must select select artist!")
    public Artist getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public UserServiceModel getAddedFrom() {
        return addedFrom;
    }

    public AlbumAddBindingModel setAddedFrom(UserServiceModel addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
