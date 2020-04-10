package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    private List<BookDto> getBooks(){
        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(Long bookId) throws RecordNotFoundException {
        return bookMapper.mapToBookDto(bookService.getBook(bookId).orElseThrow(RecordNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(Long bookId) {
        bookService.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookMapper.mapToBook(bookDto));
    }

}
