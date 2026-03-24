package com.gal.dao;
import com.gal.model.Issue;
import com.gal.model.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueDao extends JpaRepository<Issue , Long> {

//    List<Issue> findByEmployeeidAndStatusNotIn(int emplooyeeid, List<String> listStatus);

    @Query("select i from Issue i where i.employee.id = :id AND i.issueStatus <> :status")
    List<Issue> findUnresolvedIssuesByEmployeeId(Long id , IssueStatus status);

    @Query("select i from Issue i where MONTH(i.createdAt) = MONTH(CURRENT_DATE)" +
            "and YEAR(i.createdAt) = YEAR(CURRENT_DATE)")
    List<Issue> findAllIssueOfCurrentMonth();

    @Query("select i from Issue i where MONTH(i.createdAt) = MONTH(CURRENT_DATE)" +
            "and YEAR(i.createdAt) = YEAR(CURRENT_DATE)")
    List<Issue> findRaisedIssueInCurrentMonth();
}
