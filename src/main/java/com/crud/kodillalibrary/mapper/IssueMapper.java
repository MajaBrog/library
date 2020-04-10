package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueMapper {

    public Issue mapToIssue(final IssueDto issueDto){
        return new Issue(
                issueDto.getCopy(),
                issueDto.getUser()
        );
    }
    public IssueDto mapToIssueDto(final Issue issue){
        return new IssueDto(
                issue.getCopy(),
                issue.getUser()
        );
    }

    public List<IssueDto> mapToIssueDtoList(final List<Issue> issueList){
        return issueList.stream()
                .map(i->new IssueDto(i.getCopy(),i.getUser()))
                .collect(Collectors.toList());
    }

}
