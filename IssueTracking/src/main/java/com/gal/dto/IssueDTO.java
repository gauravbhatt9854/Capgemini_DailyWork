package com.gal.dto;

import com.gal.model.Employee;
import com.gal.model.Issue;
import com.gal.model.IssueStatus;
import com.gal.model.IssueType;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
public class IssueDTO {
    private Long id;
    private IssueType issueType;
    private String description;
    private IssueStatus issueStatus;
    private Date createdAt;
    private String employeeName;

    public IssueDTO(Issue issue){
        this.id = issue.getId();
        this.issueType = issue.getIssueType();
        this.description = issue.getDescription();
        this.employeeName = issue.getEmployee().getName();
        this.issueStatus = issue.getIssueStatus();
        this.createdAt = issue.getCreatedAt();
    }
}
