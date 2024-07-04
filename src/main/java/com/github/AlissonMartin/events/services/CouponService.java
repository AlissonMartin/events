package com.github.AlissonMartin.events.services;

import com.github.AlissonMartin.events.domain.coupon.Coupon;
import com.github.AlissonMartin.events.domain.event.Event;
import com.github.AlissonMartin.events.dto.CouponRequestDTO;
import com.github.AlissonMartin.events.repositories.CouponRepository;
import com.github.AlissonMartin.events.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    EventRepository eventRepository;

    public Coupon create(CouponRequestDTO data) {
        Coupon coupon = new Coupon();

        Optional<Event> eventOptional = eventRepository.findById(data.event_id());

        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Event not found");
        }

        Event event = eventOptional.get();

        coupon.setCode(data.code());
        coupon.setDiscount(data.discount());
        coupon.setEvent(event);
        coupon.setValid(new Date(data.valid()));

        couponRepository.save(coupon);

        return coupon;
    }
}
