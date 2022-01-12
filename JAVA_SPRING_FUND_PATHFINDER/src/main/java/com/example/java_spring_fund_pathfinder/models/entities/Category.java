package com.example.java_spring_fund_pathfinder.models.entities;

import com.example.java_spring_fund_pathfinder.models.entities.enums.CategoryNameEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String description;
    private CategoryNameEnum name;
    private Set<Route> routes;

    public Category() {
        this.routes = new HashSet<>();
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Route> getRoutes() {
        return routes;
    }

    public Category setRoutes(Set<Route> routes) {
        this.routes = routes;
        return this;
    }
}
