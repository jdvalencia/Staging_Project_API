package com.initiative.Initiative.controllers;

import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.entities.Event;
import com.initiative.Initiative.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDTO> findAllEvents(){
        return eventService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EventDTO saveEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }
}
