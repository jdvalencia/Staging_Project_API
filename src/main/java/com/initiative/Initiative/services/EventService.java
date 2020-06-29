package com.initiative.Initiative.services;

import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.entities.Event;
import com.initiative.Initiative.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventRepository;

    public List<EventDTO> findAll() {
        List<Event> allEvents = new ArrayList<>();
        eventRepository.findAll().forEach(allEvents::add);
        List<EventDTO> eventDTOS = new ArrayList<>();
        for (Event e : allEvents) {
            EventDTO eventDTO = new EventDTO(e);
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }

    public EventDTO saveEvent(Event event) {
        Event persisted = eventRepository.save(event);
        System.out.println(persisted);
        return new EventDTO(persisted);
    }
}
