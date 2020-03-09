package com.michal.flightreservation.service;

import com.michal.flightreservation.dto.ReservationRequest;
import com.michal.flightreservation.entities.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);

}
