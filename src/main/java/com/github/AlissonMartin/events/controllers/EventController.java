package com.github.AlissonMartin.events.controllers;

import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.EventRepository;
import com.github.AlissonMartin.events.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  EventRepository eventRepository;

  @Autowired
  EventService eventService;

  @PostMapping
  public ResponseEntity<Event> create(@RequestBody EventRequestDTO body) {
    Event event = this.eventService.create(body);
    return ResponseEntity.ok(event);
  }

  @GetMapping

  public ResponseEntity<List<Event>> list() {
    List<Event> events = eventRepository.findAll();
    return ResponseEntity.ok(events);
  }
}
