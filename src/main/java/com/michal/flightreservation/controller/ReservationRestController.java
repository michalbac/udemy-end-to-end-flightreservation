package com.michal.flightreservation.controller;


import com.michal.flightreservation.dto.ReservationUpdateRequest;
import com.michal.flightreservation.entities.Reservation;
import com.michal.flightreservation.repository.ReservartionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    ReservartionRepository reservartionRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable Long id) {
        LOGGER.info("Inside findReservation");
        Optional<Reservation> reservationOptional = reservartionRepository.findById(id);
        if (reservationOptional.isPresent()){
            LOGGER.info("Reservation with id: {} found", id);
            return reservationOptional.get();
        }
        LOGGER.warn("Reservation with id: {} not found", id);
        return null;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        LOGGER.info("Inside updateReservation for:" + request);
        Optional<Reservation> reservationOptional = reservartionRepository.findById(request.getId());
        Reservation updatedReservation = null;
        if (reservationOptional.isPresent()){
            Reservation reservation;
            reservation = reservationOptional.get();
            reservation.setNumberOfBags(request.getNumberOfBags());
            reservation.setCheckedIn(request.isCheckedIn());
            LOGGER.info("Saving reservation");
            updatedReservation = reservartionRepository.save(reservation);
        }
        return updatedReservation;
    }
}
