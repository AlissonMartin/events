package com.github.AlissonMartin.events.dto;

import java.math.BigDecimal;
import java.util.Date;

public record CouponRequestDTO(String code, BigDecimal discount, String valid, Integer event_id) {

}
