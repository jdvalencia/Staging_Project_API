package com.initiative.Initiative.services;

import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.entities.Event;
import com.initiative.Initiative.exceptions.ResourceNotFoundException;
import com.initiative.Initiative.repositories.EventsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventRepository;

    public List<EventDTO> findAll() {
        List<Event> allEvents = new ArrayList<>();
        List<Event> emptyList = Collections.EMPTY_LIST;
        eventRepository.findAll().forEach(allEvents::add);
        if(emptyList.equals(allEvents)){

        }
        List<EventDTO> eventDTOS = new ArrayList<>();
        for (Event e : allEvents) {
            EventDTO eventDTO = new EventDTO(e);
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }

    public EventDTO saveEvent(Event event) {
        Event persisted = eventRepository.save(event);
        return new EventDTO(persisted);
    }

    public boolean deleteEvent(int id) {
        try {
            eventRepository.deleteById(id);
        }
        catch (NoResultException e) {
            return true;
        }
        return true;
    }
}
