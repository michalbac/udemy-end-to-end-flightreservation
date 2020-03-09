package com.michal.flightreservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardDto {
    private String nameOnTheCard;

    private String cardNumber;

    private String expireDate;

    private String securityCode;
}
