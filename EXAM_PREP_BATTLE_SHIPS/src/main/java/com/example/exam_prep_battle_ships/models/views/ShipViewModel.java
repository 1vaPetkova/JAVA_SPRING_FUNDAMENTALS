package com.example.exam_prep_battle_ships.models.views;

public class ShipViewModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private String status;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ShipViewModel setStatus() {
        this.status = String.format("%s -- %d -- w%d", this.name, this.health, this.power);
        return this;
    }
}
