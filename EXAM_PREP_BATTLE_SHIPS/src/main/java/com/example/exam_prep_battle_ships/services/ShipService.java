package com.example.exam_prep_battle_ships.services;

import com.example.exam_prep_battle_ships.models.binding.FightBindingModel;
import com.example.exam_prep_battle_ships.models.binding.ShipAddBindingModel;
import com.example.exam_prep_battle_ships.models.services.ShipServiceModel;
import com.example.exam_prep_battle_ships.models.views.ShipViewModel;

import java.util.List;

public interface ShipService {
    boolean addShip(ShipAddBindingModel shipAddBindingModel);

    List<ShipViewModel> getAllShips();

    List<String> getShipsOfCurrentUser();

    List<String> getShipsOfOtherUsers();

    void fight(FightBindingModel fightBindingModel);
}
