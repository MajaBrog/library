package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Copy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CopyRepository extends CrudRepository<Copy,Long> {

    @Override
    List<Copy> findAll();

    @Override
    Optional<Copy> findById(Long id);

    @Override
    Copy save(Copy copy);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
