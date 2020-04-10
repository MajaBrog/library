package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long id);

    @Override
    Book save(Book book);

    @Override
    void deleteById(Long id);

}
