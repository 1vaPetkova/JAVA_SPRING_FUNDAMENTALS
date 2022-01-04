package com.example.java_spring_fund_pathfinder.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    private Instant dateTime;
    private String textContent;
    private User author;
    private User recipient;

    @Column(name = "date_time",nullable = false)
    public Instant getDateTime() {
        return dateTime;
    }

    public Message setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @Column(name = "text_context", columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Message setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Message setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public User getRecipient() {
        return recipient;
    }

    public Message setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
