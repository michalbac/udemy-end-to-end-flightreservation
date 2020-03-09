package com.michal.flightreservation.service;

import com.michal.flightreservation.dto.ReservationRequest;
import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.entities.Passenger;
import com.michal.flightreservation.entities.Reservation;
import com.michal.flightreservation.repository.PassengerRepository;
import com.michal.flightreservation.repository.ReservartionRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Getter
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservartionRepository reservartionRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
// Make payment
        Long flightId = request.getFlightId();
        Flight flight = flightService.getFlightById(flightId);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservartionRepository.save(reservation);

        return savedReservation;

    }
}



