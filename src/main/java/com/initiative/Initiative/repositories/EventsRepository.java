package com.initiative.Initiative.repositories;

import com.initiative.Initiative.entities.AppUser;
import com.initiative.Initiative.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends CrudRepository<Event, Integer> {

    public List<Event> findAllByAppUser(AppUser appUser);
}
