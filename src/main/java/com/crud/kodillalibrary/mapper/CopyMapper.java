package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.controller.RecordNotFoundException;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.CopyDto;
import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {
    @Autowired
    private BookService bookService;

    public Copy mapToCopy(CopyDto copyDto) {
        return new Copy(
                bookService.getBook(copyDto.getBookId()).orElseThrow(RecordNotFoundException::new));
    }

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getStatus());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList){
        return copyList.stream()
                .map(c->new CopyDto(c.getId(),c.getBook().getId(),c.getStatus()))
                .collect(Collectors.toList());
    }
}