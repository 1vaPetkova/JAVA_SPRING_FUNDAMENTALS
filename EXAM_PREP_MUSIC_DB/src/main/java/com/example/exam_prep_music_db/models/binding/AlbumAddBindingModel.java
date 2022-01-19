package com.example.exam_prep_music_db.models.binding;

import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;
import com.example.exam_prep_music_db.models.entities.enums.GenreEnum;
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
    private GenreEnum genre;
    private ArtistNameEnum artist;

    public AlbumAddBindingModel() {
    }

    @NotBlank(message = "Name cannot be empty!")
    @Size(min = 3, max = 10, message = "Name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Image Url cannot be empty!")
    @Size(min = 5, message = "Image Url length must be minimum 5 characters!")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotBlank(message = "Description cannot be empty!")
    @Size(min = 5, message = "Description length must be minimum 5 characters!")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Copies cannot be empty!")
    @Min(value = 10, message = "Copies must be more than or equal to 10!")
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @NotNull(message = "Price cannot be empty!")
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
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @NotNull(message = "You must select select artist!")
    public ArtistNameEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistNameEnum artist) {
        this.artist = artist;
        return this;
    }

}
