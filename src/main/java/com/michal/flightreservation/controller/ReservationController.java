package com.michal.flightreservation.controller;

import com.michal.flightreservation.dto.CardDto;
import com.michal.flightreservation.dto.PassengerDto;
import com.michal.flightreservation.dto.ReservationRequest;
import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.entities.Reservation;
import com.michal.flightreservation.service.FlightService;
import com.michal.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam Long flightId, ModelMap modelMap) {
        Flight flight = flightService.getFlightById(flightId);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully and the id is:  " + reservation.getId());
        return "reservationConfirmation";
    }
}
