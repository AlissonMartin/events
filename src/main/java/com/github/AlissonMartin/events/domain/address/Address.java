package com.github.AlissonMartin.events.domain.address;

import com.github.AlissonMartin.events.domain.event.Event;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private String state;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
