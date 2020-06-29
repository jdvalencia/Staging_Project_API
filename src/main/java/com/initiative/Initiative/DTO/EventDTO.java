package com.initiative.Initiative.DTO;

import com.initiative.Initiative.entities.Event;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class EventDTO {

    private int id;
    private String name;
    private String location;
    private String date;
    private String time;

    public EventDTO() {
    }

    public EventDTO(Event event){
        String hours,minutes;
        this.id = event.getId();
        this.name = event.getName();
        this.location = event.getLocation();
        this.date= event.getDate();

        if(event.getMinutes() <= 30) {
            switch (event.getHours()){
                case 2:
                    hours = "two";
                    break;
                case 3:
                    hours = "three";
                    break;
                case 4:
                    hours = "four";
                    break;
                case 5:
                    hours = "five";
                    break;
                case 6:
                    hours = "six";
                    break;
                case 7:
                    hours = "seven";
                    break;
                case 8:
                    hours = "eight";
                    break;
                case 9:
                    hours = "nine";
                    break;
                case 10:
                    hours = "ten";
                    break;
                case 11:
                    hours = "eleven";
                    break;
                case 12:
                    hours = "twelve";
                    break;
                default:
                    hours = "one";
            }
            switch (event.getMinutes()) {
                case 1:
                    minutes = "one";
                    break;
                case 2:
                    minutes = "two";
                    break;
                case 3:
                    minutes = "three";
                    break;
                case 4:
                    minutes = "four";
                    break;
                case 5:
                    minutes = "five";
                    break;
                case 6:
                    minutes = "six";
                    break;
                case 7:
                    minutes = "seven";
                    break;
                case 8:
                    minutes = "eight";
                    break;
                case 9:
                    minutes = "nine";
                    break;
                case 10:
                    minutes = "ten";
                    break;
                case 11:
                    minutes = "eleven";
                    break;
                case 12:
                    minutes = "twelve";
                    break;
                case 13:
                    minutes = "thirteen";
                    break;
                case 14:
                    minutes = "fourteen";
                    break;
                case 15:
                    minutes = "quarter";
                    break;
                case 16:
                    minutes = "sixteen";
                    break;
                case 17:
                    minutes = "seventeen";
                    break;
                case 18:
                    minutes = "eigthteen";
                    break;
                case 19:
                    minutes = "nineteen";
                    break;
                case 20:
                    minutes = "twenty";
                    break;
                case 21:
                    minutes = "twenty one";
                    break;
                case 22:
                    minutes = "twenty two";
                    break;
                case 23:
                    minutes = "twenty three";
                    break;
                case 24:
                    minutes = "twenty four";
                    break;
                case 25:
                    minutes = "twenty five";
                    break;
                case 26:
                    minutes = "twenty six";
                    break;
                case 27:
                    minutes = "twenty seven";
                    break;
                case 28:
                    minutes = "twenty eight";
                    break;
                case 29:
                    minutes = "twenty nine";
                    break;
                case 30:
                    minutes = "half";
                    break;
                default:
                    minutes = "o'clock";
            }
            if (event.getMinutes() == 0) {
                this.time = hours + " " + minutes;
            } else if (event.getMinutes() == 1) {
                this.time = minutes + " minute past " + hours;
            }
            else if(event.getMinutes() == 15 || event.getMinutes() == 30){
                this.time = minutes + " past " + hours;
            }
            else{
                this.time = minutes + " minutes past " + hours;
            }
        }
        else if(event.getMinutes() > 30){
            int hoursTo = event.getHours() + 1;
            switch (hoursTo){
                case 2:
                    hours = "two";
                    break;
                case 3:
                    hours = "three";
                    break;
                case 4:
                    hours = "four";
                    break;
                case 5:
                    hours = "five";
                    break;
                case 6:
                    hours = "six";
                    break;
                case 7:
                    hours = "seven";
                    break;
                case 8:
                    hours = "eight";
                    break;
                case 9:
                    hours = "nine";
                    break;
                case 10:
                    hours = "ten";
                    break;
                case 11:
                    hours = "eleven";
                    break;
                case 12:
                    hours = "twelve";
                    break;
                default:
                    hours = "one";
            }
            int minutesTo = 60 - event.getMinutes();
            switch (minutesTo) {
                case 1:
                    minutes = "one";
                    break;
                case 2:
                    minutes = "two";
                    break;
                case 3:
                    minutes = "three";
                    break;
                case 4:
                    minutes = "four";
                    break;
                case 5:
                    minutes = "five";
                    break;
                case 6:
                    minutes = "six";
                    break;
                case 7:
                    minutes = "seven";
                    break;
                case 8:
                    minutes = "eight";
                    break;
                case 9:
                    minutes = "nine";
                    break;
                case 10:
                    minutes = "ten";
                    break;
                case 11:
                    minutes = "eleven";
                    break;
                case 12:
                    minutes = "twelve";
                    break;
                case 13:
                    minutes = "thirteen";
                    break;
                case 14:
                    minutes = "fourteen";
                    break;
                case 15:
                    minutes = "quarter";
                    break;
                case 16:
                    minutes = "sixteen";
                    break;
                case 17:
                    minutes = "seventeen";
                    break;
                case 18:
                    minutes = "eigthteen";
                    break;
                case 19:
                    minutes = "nineteen";
                    break;
                case 20:
                    minutes = "twenty";
                    break;
                case 21:
                    minutes = "twenty one";
                    break;
                case 22:
                    minutes = "twenty two";
                    break;
                case 23:
                    minutes = "twenty three";
                    break;
                case 24:
                    minutes = "twenty four";
                    break;
                case 25:
                    minutes = "twenty five";
                    break;
                case 26:
                    minutes = "twenty six";
                    break;
                case 27:
                    minutes = "twenty seven";
                    break;
                case 28:
                    minutes = "twenty eight";
                    break;
                case 29:
                    minutes = "twenty nine";
                    break;
                case 30:
                    minutes = "half";
                    break;
                default:
                    minutes = "o'clock";
            }
            this.time = minutes + " to " + hours;
        }
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return id == eventDTO.id &&
                Objects.equals(name, eventDTO.name) &&
                Objects.equals(location, eventDTO.location) &&
                Objects.equals(date, eventDTO.date) &&
                Objects.equals(time, eventDTO.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, date, time);
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
