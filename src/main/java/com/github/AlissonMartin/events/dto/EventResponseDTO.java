package com.github.AlissonMartin.events.dto;

import com.github.AlissonMartin.events.domain.address.Address;

import java.util.Date;
import java.util.List;

public record EventResponseDTO(Integer id, String title, String description, boolean remote, Date date, Address address) {
}
