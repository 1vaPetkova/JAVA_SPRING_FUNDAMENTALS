package com.example.exam_prep_music_db.models.entities;

import com.example.exam_prep_music_db.models.entities.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {
    private ArtistNameEnum name;
    private String careerInformation;

    public Artist() {
    }

    public Artist(ArtistNameEnum name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }

    public Artist setName(ArtistNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "career_information",columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
