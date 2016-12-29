package org.jug.montpellier.ai.actions;

import java.util.Date;

public class Conference {

    private Integer id;
    private String title;
    private Date date;
    private String description;
    private String location;

    public Integer getId() {
        return id;
    }

    public Conference setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Conference setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Conference setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Conference setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Conference setLocation(String location) {
        this.location = location;
        return this;
    }
}
