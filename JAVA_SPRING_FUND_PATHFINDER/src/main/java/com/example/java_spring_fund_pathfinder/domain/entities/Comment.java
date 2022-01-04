package com.example.java_spring_fund_pathfinder.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private Boolean approved;
    private Instant created;
    private String textContent;
    private Route route;
    private User author;

    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    @Column(nullable = false)
    public Instant getCreated() {
        return created;
    }

    public Comment setCreated(Instant created) {
        this.created = created;
        return this;
    }

    @Column(name = "text_content",nullable = false, columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }
}
