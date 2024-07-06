package com.github.AlissonMartin.events.repositories;

import com.github.AlissonMartin.events.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface EventRepository extends JpaRepository<Event, Integer> {

  @Query("SELECT e FROM Event e LEFT JOIN e.address a " +
          "WHERE (:city = '' OR a.city LIKE %:city%) " +
          "AND (:state = '' OR a.state LIKE %:state%) " +
          "AND (e.date >= :startDate AND e.date <= :endDate)")
  Page<Event> findFilteredEvents(@Param("city") String city,
                                 @Param("state") String state,
                                 @Param("startDate") Date startDate,
                                 @Param("endDate") Date endDate,
                                 Pageable pageable);
}
