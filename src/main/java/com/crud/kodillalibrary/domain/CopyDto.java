package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {
    private Long id;
    private Long bookId;
    private Status status;

    public CopyDto(Long bookId) {
        this.bookId = bookId;
    }
}
