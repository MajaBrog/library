package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class IssueDto {
    private Long id;
    @JsonProperty("copy")
    private Copy copy;
    @JsonProperty("user")
    private User user;
    private LocalDate dateOfIssue;
    private LocalDate dueDate;

    public IssueDto(Copy copy, User user) {
        this.copy = copy;
        this.user = user;
    }
}
