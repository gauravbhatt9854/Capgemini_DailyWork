package com.gal.service.impl;

import com.gal.controller.IssueController;
import com.gal.dao.EmployeeDao;
import com.gal.dao.IssueDao;
import com.gal.model.Employee;
import com.gal.model.Issue;
import com.gal.model.IssueStatus;
import com.gal.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueDao issueDao;
    @Autowired
    private EmployeeDao employeeDao;

    private final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @Override
    public List<Issue> findUnresolvedIssuesByEmployeeId(Long id) throws IllegalArgumentException {
        Optional<Employee> employee = employeeDao.findById(id);
        if(employee.isEmpty()){
            throw  new IllegalArgumentException("incorrect emloyee id : " + id);
        }
        return issueDao.findUnresolvedIssuesByEmployeeId(id, IssueStatus.RESOLVED);
    }

    @Override
    public List<Issue> findAllIssueOfCurrentMonth() {
        return issueDao.findAllIssueOfCurrentMonth();
    }

    @Override
    public Set<String> findEmployeeNameWhoRaisedIssueInCurrentMonth() {
        List<Issue> list = issueDao.findRaisedIssueInCurrentMonth();
        return list.stream()
                .map(x-> x.getEmployee().getName()).collect(Collectors.toSet());
    }
}
