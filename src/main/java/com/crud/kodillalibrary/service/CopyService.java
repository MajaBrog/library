package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.controller.RecordNotFoundException;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Issue;
import com.crud.kodillalibrary.domain.Mail;
import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class CopyService {
    @Autowired
    private CopyRepository repository;
    @Autowired
    private IssueService issueService;

    public List<Copy> getAllCopiesOfBook(final Long bookId) {
        return repository.findAll().stream()
                .filter(c -> c.getBook().getId().equals(bookId))
                .collect(Collectors.toList());
    }

    public Optional<Copy> getCopy(final Long id) {
        return repository.findById(id);
    }

    public Copy saveCopy(final Copy book) {
        return repository.save(book);
    }

    public void deleteCopy(final Long id) {
        repository.deleteById(id);
    }
}
