package com.github.AlissonMartin.events.domain.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(name = "events")
@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private String imgUrl;

    private String eventUrl;

    private boolean remote;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
