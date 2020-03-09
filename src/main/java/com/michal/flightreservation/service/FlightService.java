package com.michal.flightreservation.service;

import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.entities.Reservation;

import java.util.List;

public interface FlightService {

    Flight saveFlight(Flight flight);

    Flight updateFlight(Flight flight);

    void deleteFlight(Flight flight);

    Flight getFlightById(long id);

    List<Flight> getAllflights();

}
