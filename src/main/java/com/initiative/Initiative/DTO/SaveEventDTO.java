package com.initiative.Initiative.DTO;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SaveEventDTO {

    private String name;
    private String location;
    private String date;
    private int hours;
    private int minutes;
    private int user_id;

    public SaveEventDTO() {
    }

    public SaveEventDTO(String name, String location, String date, int hours, int minutes, int appUserId) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
        this.user_id = appUserId;
    }

    public SaveEventDTO(String name, String location, String date, int hours, int minutes) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
