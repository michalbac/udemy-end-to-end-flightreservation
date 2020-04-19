package com.michal.flightreservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Long flightId;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String nameOnTheCard;
    private String cardNumber;
    private String expireDate;
    private String securityCode;

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "flightId=" + flightId +
                ", passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", passengerPhone='" + passengerPhone + '\'' +
                ", nameOnTheCard='" + nameOnTheCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
