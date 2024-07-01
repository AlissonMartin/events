package com.github.AlissonMartin.events.repositories;

import com.github.AlissonMartin.events.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
