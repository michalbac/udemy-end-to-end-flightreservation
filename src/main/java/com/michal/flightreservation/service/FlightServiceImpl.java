package com.michal.flightreservation.service;

import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public Flight getFlightById(long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        Flight flight = null;
        if(flightOptional.isPresent()){
            flight = flightOptional.get();
        }
        return flight;
    }

    @Override
    public List<Flight> getAllflights() {
        return flightRepository.findAll();
    }
}
