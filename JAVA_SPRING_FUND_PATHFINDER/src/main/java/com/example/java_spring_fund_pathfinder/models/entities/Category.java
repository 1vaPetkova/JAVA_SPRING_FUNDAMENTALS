package com.example.java_spring_fund_pathfinder.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String description;
    private String name;
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

    @Column(nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public Category setName(String name) {
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
