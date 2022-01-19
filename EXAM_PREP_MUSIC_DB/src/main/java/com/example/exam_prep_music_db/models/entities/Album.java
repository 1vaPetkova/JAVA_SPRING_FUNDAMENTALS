package com.example.exam_prep_music_db.models.entities;

import com.example.exam_prep_music_db.models.entities.enums.GenreEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private Artist artist;
    private User addedFrom;

    public Album() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "image_url", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public Album setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "released_date", nullable = false)
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public GenreEnum getGenre() {
        return genre;
    }

    public Album setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @ManyToOne
    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="added_from", referencedColumnName = "id")
    public User getAddedFrom() {
        return addedFrom;
    }

    public Album setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
