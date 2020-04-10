package com.crud.kodillalibrary.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private LocalDate dateOfAccountCreation;
    @Column
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email=email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Issue> issues = new ArrayList<>();
}
