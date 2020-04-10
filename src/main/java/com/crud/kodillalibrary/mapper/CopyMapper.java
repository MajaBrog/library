package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.CopyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {
    public Copy mapToCopy(CopyDto copyDto) {
        return new Copy(
                copyDto.getBook(),
                copyDto.getStatus());
    }

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(
                copy.getBook(),
                copy.getStatus()
        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList){
        return copyList.stream()
                .map(c->new CopyDto(c.getBook(),c.getStatus()))
                .collect(Collectors.toList());
    }
}