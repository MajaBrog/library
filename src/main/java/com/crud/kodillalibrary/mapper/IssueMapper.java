package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.controller.RecordNotFoundException;
import com.crud.kodillalibrary.domain.*;
import com.crud.kodillalibrary.service.CopyService;
import com.crud.kodillalibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueMapper {

    @Autowired
    CopyService copyService;
    @Autowired
    UserService userService;

    public Issue mapToIssue(final IssueDto issueDto){
        return new Issue(
                copyService.getCopy(issueDto.getCopyId()).orElseThrow(RecordNotFoundException::new),
                userService.getUser(issueDto.getUserId()).orElseThrow(RecordNotFoundException::new)
        );
    }
    public IssueDto mapToIssueDto(final Issue issue){
        return new IssueDto(
                issue.getId(),
                issue.getCopy().getId(),
                issue.getUser().getId(),
                issue.getDateOfIssue(),
                issue.getDueDate()
        );
    }

    public List<IssueDto> mapToIssueDtoList(final List<Issue> issueList){
        return issueList.stream()
                .map(i->new IssueDto(i.getId(),i.getCopy().getId(),i.getUser().getId(),i.getDateOfIssue(),i.getDueDate()))
                .collect(Collectors.toList());
    }

}
