package com.github.AlissonMartin.events.domain.coupon;


import com.github.AlissonMartin.events.domain.event.Event;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue
    private int id;

    private String code;

    private BigDecimal discount;

    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
