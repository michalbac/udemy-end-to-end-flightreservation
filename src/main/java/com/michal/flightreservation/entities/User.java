package com.michal.flightreservation.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity{
    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
