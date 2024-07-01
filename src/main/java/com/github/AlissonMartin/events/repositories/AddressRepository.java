package com.github.AlissonMartin.events.repositories;

import com.github.AlissonMartin.events.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
