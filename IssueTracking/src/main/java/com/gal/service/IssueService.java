package com.gal.service;

import com.gal.model.Issue;
import com.gal.model.IssueStatus;

import java.util.List;
import java.util.Set;

public interface IssueService {
    List<Issue> findUnresolvedIssuesByEmployeeId(Long id) throws IllegalArgumentException;

    List<Issue> findAllIssueOfCurrentMonth();

    Set<String> findEmployeeNameWhoRaisedIssueInCurrentMonth();
}
