package com.example.exam_prep_battle_ships.services.impl;

import com.example.exam_prep_battle_ships.models.binding.FightBindingModel;
import com.example.exam_prep_battle_ships.models.binding.ShipAddBindingModel;
import com.example.exam_prep_battle_ships.models.entities.Ship;
import com.example.exam_prep_battle_ships.models.services.ShipServiceModel;
import com.example.exam_prep_battle_ships.models.views.ShipViewModel;
import com.example.exam_prep_battle_ships.repositories.ShipRepository;
import com.example.exam_prep_battle_ships.services.CategoryService;
import com.example.exam_prep_battle_ships.services.ShipService;
import com.example.exam_prep_battle_ships.services.UserService;
import com.example.exam_prep_battle_ships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;
    private final UserService userService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, CategoryService categoryService, UserService userService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public boolean addShip(ShipAddBindingModel shipAddBindingModel) {
        try {
            ShipServiceModel shipServiceModel = this.modelMapper
                    .map(shipAddBindingModel, ShipServiceModel.class);
            this.shipRepository.save(this.modelMapper.map(shipServiceModel, Ship.class)
                    .setUser(this.userService.findUserById(this.currentUser.getId()))
                    .setCategory(this.categoryService
                            .findByCategoryEnum(shipServiceModel.getCategory())));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<ShipViewModel> getAllShips() {
        return this.shipRepository
                .findAllOrderByNameHealthPower()
                .stream()
                .map(ship -> this.modelMapper.map(ship, ShipViewModel.class).setStatus())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getShipsOfCurrentUser() {
        return this.shipRepository.findAll()
                .stream().filter(ship -> Objects.equals(ship.getUser().getId(), this.currentUser.getId()))
                .map(Ship::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getShipsOfOtherUsers() {
        return this.shipRepository.findAll()
                .stream().filter(ship -> !Objects.equals(ship.getUser().getId(), this.currentUser.getId()))
                .map(Ship::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void fight(FightBindingModel fightBindingModel) {
        Ship attacker = this.shipRepository.findByName(fightBindingModel.getAttacker());
        Ship defender = this.shipRepository.findByName(fightBindingModel.getDefender());
        Long power = attacker.getPower();
        defender.setHealth(defender.getHealth() - power);
        if (defender.getHealth() <= 0) {
            this.shipRepository.deleteById(defender.getId());
        } else {
            this.shipRepository.save(defender);
        }
    }
}
