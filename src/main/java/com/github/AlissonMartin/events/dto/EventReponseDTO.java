package com.github.AlissonMartin.events.dto;

import com.github.AlissonMartin.events.domain.address.Address;

import java.util.Date;
import java.util.List;

public record EventReponseDTO(Integer id, String title, String description, boolean remote, Date date, List<Address> addresses) {
}
