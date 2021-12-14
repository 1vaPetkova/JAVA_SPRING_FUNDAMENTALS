package com.example.java_spring_fund_lab_01.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private Long id;

    private Instant created;
    private Instant modified;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant repeated) {
        this.modified = repeated;
    }
}
