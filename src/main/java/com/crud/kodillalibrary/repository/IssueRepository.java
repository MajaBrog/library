package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Issue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends CrudRepository<Issue,Long> {
    @Override
    List<Issue> findAll();

    @Override
    Optional<Issue> findById(Long id);

    @Override
    Issue save(Issue issue);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
