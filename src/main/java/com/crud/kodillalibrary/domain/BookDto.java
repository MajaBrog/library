package com.crud.kodillalibrary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publicationYear;

    public BookDto(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
