package com.michal.flightreservation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Flight extends AbstractEntity{
    private String flightNumber;

    private String operatingAirlines;

    private String departureCity;

    private String arrivalCity;

    private Date dateOfDeparture;

    private Timestamp estimatedDepartureTime;

}
