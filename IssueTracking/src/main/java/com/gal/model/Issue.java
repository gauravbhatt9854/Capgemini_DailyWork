package com.gal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Issue {
    @SequenceGenerator(name = "issue_sequence" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "issue_sequence")
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private IssueType issueType;
    private String description;
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;
    private Date createdAt;

    @JoinColumn(name = "raisedBy")
    @ManyToOne
    private Employee employee;


}
