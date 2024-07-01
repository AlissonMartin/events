package com.github.AlissonMartin.events.repositories;

import com.github.AlissonMartin.events.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
