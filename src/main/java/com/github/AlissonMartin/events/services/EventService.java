package com.github.AlissonMartin.events.services;

import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventReponseDTO;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public List<EventReponseDTO> getEvents(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Event> eventPage = this.repository.findAll(pageable);
    return eventPage.map(event -> new EventReponseDTO(event.getId(), event.getTitle(), event.getDescription(), event.isRemote(), event.getDate(), event.getAddressList())).stream().toList();
  }
}
