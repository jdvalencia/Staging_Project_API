package com.initiative.Initiative.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.DTO.SaveEventDTO;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String date;

    @Column
    private int hours;

    @Column
    private int minutes;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private AppUser appUser;

    public Event() {
    }

    public Event(SaveEventDTO saveEventDTO) {
        this.name = saveEventDTO.getName();
        this.location = saveEventDTO.getLocation();
        this.date = saveEventDTO.getDate();
        this.hours = saveEventDTO.getHours();
        this.minutes = saveEventDTO.getMinutes();
    }

    public Event(int id, String name, String location, String date, int hours, int minutes, AppUser appUser) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
        this.appUser = appUser;
    }

    public Event(String name, String location, String date, int hours, int minutes, AppUser appUser) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
        this.appUser = appUser;
    }

    public Event(String name, String location, String date, int hours, int minutes) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public Event setAppUser(AppUser appUser) {
        this.appUser = appUser;
        return this;
    }


}
