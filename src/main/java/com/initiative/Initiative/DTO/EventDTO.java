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
        String hoursArray[] = {"","one","two","three","four","five","six","seven","eight", "nine", "ten", "eleven", "twelve"};
        String minutesArray[] = {"o'clock", hoursArray[1], hoursArray[2], hoursArray[3], hoursArray[4], hoursArray[5], hoursArray[6], hoursArray[7],
                hoursArray[8], hoursArray[9], hoursArray[10], hoursArray[11], hoursArray[12], "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
                "eighteen","nineteen", "twenty", "twenty " + hoursArray[1], "twenty " + hoursArray[2], "twenty " + hoursArray[3], "twenty " + hoursArray[4],
                "twenty " + hoursArray[5], "twenty " + hoursArray[6], "twenty " + hoursArray[7], "twenty " + hoursArray[8], "twenty " + hoursArray[9], "half"};
        this.id = event.getId();
        this.name = event.getName();
        this.location = event.getLocation();
        this.date= event.getDate();

        if(event.getMinutes() <= 30) {
            int hourNumber = event.getHours();
            if(hourNumber > 12) {
                hourNumber -= 12;
            }

            hours = hoursArray[hourNumber];
            minutes = minutesArray[event.getMinutes()];
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
            int hourNumber = event.getHours();
            if(event.getHours() > 12) {
                hourNumber = event.getHours() - 12;
            }
            int hoursTo = hourNumber + 1;
            if(hoursTo == hoursArray.length){
                hoursTo = 1;
            }
            System.out.println(event.toString());
            hours = hoursArray[hoursTo];
            int minutesTo = 60 - event.getMinutes();
            minutes = minutesArray[minutesTo];
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
