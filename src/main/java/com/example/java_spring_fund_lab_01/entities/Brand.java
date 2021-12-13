package com.example.java_spring_fund_lab_01.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    private String name;
    private Instant created;
    private Instant modified;

    @Column(name = "name",unique = true,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append("name='").append(name).append('\'');
        sb.append(", created=").append(created);
        sb.append(", repeated=").append(modified);
        sb.append('}');
        return sb.toString();
    }
}
