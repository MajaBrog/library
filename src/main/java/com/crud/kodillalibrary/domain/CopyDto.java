package com.crud.kodillalibrary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CopyDto {
    private Long id;
    private Status status;
    private Book book;

    public CopyDto(Book book, Status status) {
        this.book = book;
        this.status = status;
    }
}
