package com.github.AlissonMartin.events.dto;

import java.util.Date;

public record EventRequestDTO(String title, String description, boolean remote, Date date, String city, String state) {
}
