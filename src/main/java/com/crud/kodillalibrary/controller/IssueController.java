package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.IssueDto;
import com.crud.kodillalibrary.mapper.IssueMapper;
import com.crud.kodillalibrary.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @Autowired
    private IssueMapper issueMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/issue")
    private List<IssueDto> getIssuesForUser(Long userId) {
        return issueMapper.mapToIssueDtoList(issueService.getAllIssuesForUser(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/issue/{issueId}")
    public IssueDto getIssue(@PathVariable Long issueId) throws RecordNotFoundException {
        return issueMapper.mapToIssueDto(issueService.getIssue(issueId).orElseThrow(RecordNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/issue", consumes = APPLICATION_JSON_VALUE)
    public void createIssue(@RequestBody IssueDto issueDto) {
        issueService.createIssue(issueMapper.mapToIssue(issueDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "issue/{issueId}")
    public void returnBook(@PathVariable Long issueId) {
         issueService.returnBook(issueId);
    }
}
