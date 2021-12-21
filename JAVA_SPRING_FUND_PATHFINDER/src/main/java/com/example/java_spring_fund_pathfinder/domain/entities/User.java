package com.example.java_spring_fund_pathfinder.domain.entities;

import com.example.java_spring_fund_pathfinder.domain.entities.enums.Level;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private Integer age;
    private String fullName;
    private Level level;
    private String password;
    private String username;
    private Set<Role> roles;
    private Set<Route> routes;
    private Set<Comment> comments;
    private Set<Picture> pictures;
    private Set<Message> messagesSent;
    private Set<Message> messagesReceived;

    public User() {
        this.roles = new HashSet<>();
        this.routes = new HashSet<>();
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.messagesSent = new HashSet<>();
        this.messagesReceived = new HashSet<>();
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_entity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    @OneToMany(mappedBy = "author")
    public Set<Route> getRoutes() {
        return routes;
    }

    public User setRoutes(Set<Route> routes) {
        this.routes = routes;
        return this;
    }

    @OneToMany(mappedBy = "author")
    public Set<Comment> getComments() {
        return comments;
    }

    public User setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    @OneToMany(mappedBy = "author")
    public Set<Picture> getPictures() {
        return pictures;
    }

    public User setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @OneToMany(mappedBy = "author")
    public Set<Message> getMessagesSent() {
        return messagesSent;
    }

    public User setMessagesSent(Set<Message> messagesSent) {
        this.messagesSent = messagesSent;
        return this;
    }

    @OneToMany(mappedBy = "recipient")
    public Set<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public User setMessagesReceived(Set<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
        return this;
    }
}
