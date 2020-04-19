package com.michal.flightreservation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation extends AbstractEntity {

    @Column(name = "CHECKED_IN")
    private boolean checkedIn;
    @Column(name = "NUMBER_OF_BAGS")
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;

    @Override
    public String toString() {
        return "Reservation{" +
                "checkedIn=" + checkedIn +
                ", numberOfBags=" + numberOfBags +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
