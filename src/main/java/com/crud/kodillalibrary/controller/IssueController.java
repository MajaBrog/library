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
@RequestMapping("/v1/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @Autowired
    private IssueMapper issueMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getIssues")
    private List<IssueDto> getIssuesForUser(Long userId) {
        return issueMapper.mapToIssueDtoList(issueService.getAllIssuesForUser(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getIssue")
    public IssueDto getIssue(Long issueId) throws RecordNotFoundException {
        return issueMapper.mapToIssueDto(issueService.getIssue(issueId).orElseThrow(RecordNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createIssue", consumes = APPLICATION_JSON_VALUE)
    public void createIssue(@RequestBody IssueDto issueDto) {
        issueService.createIssue(issueMapper.mapToIssue(issueDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnBook(Long issueId) {
         issueService.returnBook(issueId);
    }
}
