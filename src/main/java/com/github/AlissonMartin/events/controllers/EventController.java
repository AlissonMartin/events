package com.github.AlissonMartin.events.controllers;

import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventResponseDTO;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.EventRepository;
import com.github.AlissonMartin.events.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
  public ResponseEntity<List<EventResponseDTO>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
    List<EventResponseDTO> events = eventService.getEvents(page, size);
    return ResponseEntity.ok(events);
  }

  @GetMapping("/filter")
  public ResponseEntity<List<EventResponseDTO>> getFilteredEvents(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam String city,
                                                       @RequestParam String uf,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
    List<EventResponseDTO> events = eventService.getFilteredEvents(page, size, city, uf, startDate, endDate);
    return ResponseEntity.ok(events);
  }
}
