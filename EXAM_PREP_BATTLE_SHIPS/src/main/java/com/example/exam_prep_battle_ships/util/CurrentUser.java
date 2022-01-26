package com.example.exam_prep_battle_ships.util;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private Long id;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }
}
