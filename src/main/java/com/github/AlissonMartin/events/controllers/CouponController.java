package com.github.AlissonMartin.events.controllers;

import com.github.AlissonMartin.events.domain.coupon.Coupon;
import com.github.AlissonMartin.events.dto.CouponRequestDTO;
import com.github.AlissonMartin.events.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> create(@RequestBody CouponRequestDTO body) {
        Coupon coupon = couponService.create(body);
        return ResponseEntity.ok(coupon);
    }
}
