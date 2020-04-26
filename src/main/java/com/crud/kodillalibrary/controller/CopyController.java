package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.CopyDto;
import com.crud.kodillalibrary.mapper.CopyMapper;
import com.crud.kodillalibrary.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class CopyController {
    @Autowired
    private CopyService copyService;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/copy")
    private List<CopyDto> getCopiesOfBook(Long bookId){
        return copyMapper.mapToCopyDtoList(copyService.getAllCopiesOfBook(bookId));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/copy/{copyId}")
    public CopyDto getCopy(@PathVariable Long copyId) throws RecordNotFoundException {
        return copyMapper.mapToCopyDto(copyService.getCopy(copyId).orElseThrow(RecordNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/copy/{copyId}")
    public void deleteCopy(@PathVariable Long copyId) {
        copyService.deleteCopy(copyId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/copy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        copyService.saveCopy(copyMapper.mapToCopy(copyDto));
    }
}
