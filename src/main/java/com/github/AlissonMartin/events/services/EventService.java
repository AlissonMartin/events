package com.github.AlissonMartin.events.services;

import com.github.AlissonMartin.events.domain.address.Address;
import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventResponseDTO;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

  @Autowired
  EventRepository repository;

  @Autowired
  AddressService addressService;

  public Event create(EventRequestDTO data) {
    Event event = new Event();
    event.setTitle(data.title());
    event.setDescription(data.description());
    event.setDate(data.date());
    event.setRemote(data.remote());


    if (!data.remote()) {
      this.addressService.createAddress(data, event);
    }

    repository.save(event);
    return event;
  }

  public List<EventResponseDTO> getEvents(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Event> eventPage = this.repository.findAll(pageable);
    return eventPage.map(event -> new EventResponseDTO(event.getId(), event.getTitle(), event.getDescription(), event.isRemote(), event.getDate(), event.getAddress())).stream().toList();
  }

  public List<EventResponseDTO> getFilteredEvents(int page, int size, String city, String uf, Date startDate, Date endDate){
    city = (city != null) ? city : "";
    uf = (uf != null) ? uf : "";
    startDate = (startDate != null) ? startDate : new Date(0);
    endDate = (endDate != null) ? endDate : new Date();

    Pageable pageable = PageRequest.of(page, size);

    Page<Event> eventsPage = this.repository.findFilteredEvents(city, uf, startDate, endDate, pageable);
    return eventsPage.stream()
            .map(event -> new EventResponseDTO(
                    event.getId(),
                    event.getTitle(),
                    event.getDescription(),
                    event.isRemote(),
                    event.getDate(),
                    event.getAddress()
            ))
            .collect(Collectors.toList());
  }
}
