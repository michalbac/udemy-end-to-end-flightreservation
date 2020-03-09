package com.michal.flightreservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PassengerDto {
    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
