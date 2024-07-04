package com.github.AlissonMartin.events.services;

import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  EventRepository repository;

  public Event create(EventRequestDTO data) {
    Event event = new Event();
    event.setTitle(data.title());
    event.setDescription(data.description());
    event.setDate(data.date());
    event.setRemote(data.remote());

    repository.save(event);

    if (!data.remote()) {

    }
    return event;
  }
}
