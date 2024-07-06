package com.github.AlissonMartin.events.services;

import com.github.AlissonMartin.events.domain.address.Address;
import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.EventRequestDTO;
import com.github.AlissonMartin.events.repositories.AddressRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  AddressRepository addressRepository;

  Address createAddress(EventRequestDTO eventRequestDTO, Event event) {
    Address address = new Address();

    address.setCity(eventRequestDTO.city());
    address.setState(eventRequestDTO.state());
    address.setEvent(event);

    return addressRepository.save(address);
  }
}
