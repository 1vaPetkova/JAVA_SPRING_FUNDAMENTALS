package com.example.exam_prep_battle_ships.models.binding;

import javax.validation.constraints.NotBlank;

public class FightBindingModel {

    private String attacker;
    private String defender;

    public FightBindingModel() {
    }

    @NotBlank(message = "Attacker cannot be empty!")
    public String getAttacker() {
        return attacker;
    }

    public FightBindingModel setAttacker(String attacker) {
        this.attacker = attacker;
        return this;
    }

    @NotBlank(message = "Defender cannot be empty!")
    public String getDefender() {
        return defender;
    }

    public FightBindingModel setDefender(String defender) {
        this.defender = defender;
        return this;
    }
}
