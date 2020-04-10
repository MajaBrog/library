package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    public void mapToBookTest() {
        //Given
        BookMapper bookMapper = new BookMapper();
        BookDto bookDto = new BookDto("title 1", "author 1", "2001");
        //When
        Book book = bookMapper.mapToBook(bookDto);
        //Then
        assertEquals(bookDto.getTitle(), book.getTitle());
        assertEquals(bookDto.getAuthor(), book.getAuthor());
        assertEquals(bookDto.getPublicationDate(), book.getPublicationYear());
    }

    @Test
    public void mapToBookDtoTest() {
    }

    @Test
    public void mapToBookDtoListTest() {
    }
}