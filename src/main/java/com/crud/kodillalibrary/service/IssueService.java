package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.controller.RecordNotFoundException;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Issue;
import com.crud.kodillalibrary.domain.Mail;
import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private SimpleEmailService emailService;

    private final static String SUBJECT = "Action on your Library Account";

    public List<Issue> getAllIssuesForUser(final Long userId) {
        return issueRepository.findAll().stream()
                .filter(i -> i.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public Optional<Issue> getIssue(final Long id) {
        return issueRepository.findById(id);
    }

    public Issue saveIssue(final Issue issue) {
        return issueRepository.save(issue);
    }

    public Issue createIssue(final Issue issue) {
        ofNullable(issue).ifPresent(i -> emailService.send(new Mail(i.getUser().getEmail(), SUBJECT,
                "New issue of:" + i.getCopy().getBook().getTitle() + ","+ i.getCopy().getBook().getAuthor() + " has been created." + "\n" +
                        "Enjoy reading and thank you for choosing our library!"),i.getUser()));
        Copy copy = issue.getCopy();
        copy.setStatus(Status.BORROWED);
        copyRepository.save(copy);
        return saveIssue(issue);
    }

    @Transactional
    public void returnBook(final Long id) {
        Issue issue = getIssue(id).orElseThrow(RecordNotFoundException::new);
        issue.setDueDate(LocalDate.now());
        saveIssue(issue);
        Copy copy = issue.getCopy();
        copy.setStatus(Status.AVAILABLE);
        copyRepository.save(copy);
        ofNullable(issue).ifPresent(i -> emailService.send(new Mail(i.getUser().getEmail(), SUBJECT,
                 i.getCopy().getBook().getTitle() + ","+ i.getCopy().getBook().getAuthor()  + " Has been returned." + "\n" +
                        "Thank you for choosing our library!"),i.getUser()));
    }


}
