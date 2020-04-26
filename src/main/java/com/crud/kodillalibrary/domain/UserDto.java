package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfAccountCreation;
    private String email;

    public UserDto(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email=email;
    }
}

