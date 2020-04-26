package com.crud.kodillalibrary.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Copy copy;
    @ManyToOne( fetch = FetchType.LAZY)
    private User user;
    @Column
    @CreationTimestamp
    private LocalDate dateOfIssue;
    @Column
    private LocalDate dueDate;

    public Issue(Copy copy, User user) {
        this.copy = copy;
        this.user = user;
    }
}
