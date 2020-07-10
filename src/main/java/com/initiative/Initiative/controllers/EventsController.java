package com.initiative.Initiative.controllers;

import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.DTO.SaveEventDTO;
import com.initiative.Initiative.config.Secured;
import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.entities.Event;
import com.initiative.Initiative.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDTO> findEventById( int id) {
        return eventService.findByAppUserId(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured(allowedRoles = {"ADMIN","USER"})
    public List<EventDTO> findAllEvents(){
        return eventService.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured(allowedRoles = {"ADMIN","USER"})
    public EventDTO saveEvent(@RequestBody SaveEventDTO event, HttpServletRequest req) {
        return eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    @Secured(allowedRoles = {"ADMIN"})
    public boolean deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }
}
