package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private Long id;
    private Long copyId;
    private Long userId;
    private LocalDate dateOfIssue;
    private LocalDate dueDate;

    public IssueDto(Long copyId, Long userId) {
        this.copyId = copyId;
        this.userId = userId;
    }

}
