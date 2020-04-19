package com.michal.flightreservation.service;

import com.michal.flightreservation.dto.ReservationRequest;
import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.entities.Passenger;
import com.michal.flightreservation.entities.Reservation;
import com.michal.flightreservation.repository.PassengerRepository;
import com.michal.flightreservation.repository.ReservartionRepository;
import com.michal.flightreservation.util.EmailUtil;
import com.michal.flightreservation.util.PDFGenerator;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@Getter
public class ReservationServiceImpl implements ReservationService {
    @Value("${com.michal.flightreservation.itinerary.dirpath}")
    private String ITINERARY_DIR;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservartionRepository reservartionRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PDFGenerator pdfGenerator;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
        // Make payment
        LOGGER.info("Book flight with id: {} started", request.getFlightId());
        Long flightId = request.getFlightId();
        LOGGER.info("Fetching flight with id: " + flightId);
        Flight flight = flightService.getFlightById(flightId);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        LOGGER.info("Saving passenger: " + passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);


        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        LOGGER.info("Saving reservation: " + reservation);
        Reservation savedReservation = reservartionRepository.save(reservation);


        String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
        LOGGER.info("Generating the itinerary");
        pdfGenerator.generateItinerary(savedReservation, filePath);
        LOGGER.info("Sending an email to: " + passenger.getEmail());
        emailUtil.sendItinerary(passenger.getEmail(), filePath);

        return savedReservation;

    }
}



