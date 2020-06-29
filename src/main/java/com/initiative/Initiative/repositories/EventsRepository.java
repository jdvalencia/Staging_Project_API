package com.initiative.Initiative.repositories;

import com.initiative.Initiative.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<Event, Integer> {
}
