package com.initiative.Initiative.services;

import com.initiative.Initiative.DTO.EventDTO;
import com.initiative.Initiative.DTO.SaveEventDTO;
import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.entities.Event;
import com.initiative.Initiative.exceptions.BadRequestException;
import com.initiative.Initiative.exceptions.ResourceNotFoundException;
import com.initiative.Initiative.repositories.AppUserRepository;
import com.initiative.Initiative.repositories.EventsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
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

    @Transactional
    public EventDTO saveEvent(SaveEventDTO savedEvent) {
        System.out.println(savedEvent.getUser_id());
        Event event = new Event(savedEvent);
        AppUser user = appUserRepository.findById(savedEvent.getUser_id()).get();
        event.setAppUser(user);
        user.addEvent(event);
        Event persisted = eventRepository.save(event);
        return new EventDTO(persisted);
    }

    @Transactional
    public boolean deleteEvent(int id) {
        try {
            Event event = eventRepository.findById(id).get();
            AppUser appUser = appUserRepository.findById(event.getAppUser().getId()).get();
            int index = 0;
            index = appUser.getEvents().indexOf(event);
            appUser.getEvents().remove(index);
            appUserRepository.save(appUser);
        }
        catch (NoResultException e) {
            System.out.println(e);
            return true;
        }
        return true;
    }

    @Transactional
    public List<EventDTO> findByAppUserId(int id) {
        List<Event> events = new ArrayList<>();
        List<EventDTO> eventDTOS = new ArrayList<>();
        AppUser appUser = new AppUser();
        if( id <= 0) {
            throw new BadRequestException();
        }
        try {
            appUser = appUserRepository.findById(id).get();
            events.addAll(eventRepository.findAllByAppUser(appUser));
        }
        catch (NoResultException e) {
            throw new ResourceNotFoundException();
        }
        eventDTOS = events.stream().map(EventDTO::new).collect(Collectors.toList());

        return eventDTOS;

    }
}
