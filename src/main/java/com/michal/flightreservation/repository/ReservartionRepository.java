package com.michal.flightreservation.repository;

import com.michal.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservartionRepository extends JpaRepository<Reservation, Long> {
}
