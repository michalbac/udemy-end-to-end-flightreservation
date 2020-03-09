package com.michal.flightreservation.controller;

import com.michal.flightreservation.entities.Flight;
import com.michal.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/findFlights")
    public String findFights(@RequestParam String from, @RequestParam String to,
                             @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
                             ModelMap modelMap) {
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        return "displayFlights";
    }
}
