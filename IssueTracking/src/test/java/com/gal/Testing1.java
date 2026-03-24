package com.gal;

import com.gal.dao.EmployeeDao;
import com.gal.dao.IssueDao;
import com.gal.model.Employee;
import com.gal.model.Issue;
import com.gal.model.IssueStatus;
import com.gal.model.IssueType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.time.LocalDate;


@SpringBootTest
public class Testing1 {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private IssueDao issueDao;

    @Rollback(value = false)
    @Transactional
    @Test
    public void addUserAndTasks(){

        for(int i =0;i<10;i++){
            Employee employee = new Employee();
            employee.setName("user"+i);
            employee.setEmail("user"+i+"@gmail.com");
            String year = "202"+ i;
            employee.setBirthDate(Date.valueOf(year+"-01-01"));


            Issue issue = new Issue();
            issue.setIssueStatus(IssueStatus.PENDING);
            issue.setIssueType(IssueType.DESKTOP_ISSUE);
            issue.setDescription("desktop is not working");
            issue.setEmployee(employee);
            issue.setCreatedAt(Date.valueOf(LocalDate.now().minusYears(i)));

            Issue issue1 = new Issue();
            issue1.setIssueStatus(IssueStatus.OPEN);
            issue1.setIssueType(IssueType.CLOUD_ISSUE);
            issue1.setDescription("cloud is not working");
            issue1.setEmployee(employee);
            issue1.setCreatedAt(Date.valueOf(LocalDate.now().minusYears(i)));


            Issue issue2 = new Issue();
            issue2.setIssueStatus(IssueStatus.RESOLVED);
            issue2.setIssueType(IssueType.ACCESS_PERMISSION);
            issue2.setDescription("i dont have access permission");
            issue2.setEmployee(employee);
            issue2.setCreatedAt(Date.valueOf(LocalDate.now().minusYears(i)));


            Issue issue3 = new Issue();
            issue3.setIssueStatus(IssueStatus.PENDING);
            issue3.setIssueType(IssueType.OTHER_ISSUE);
            issue3.setDescription("i m just kidding i don't have any issue");
            issue3.setEmployee(employee);
            issue3.setCreatedAt(Date.valueOf(LocalDate.now().minusYears(i)));


            employee.getIssues().add(issue);
            employee.getIssues().add(issue1);
            employee.getIssues().add(issue2);
            employee.getIssues().add(issue3);

            employeeDao.save(employee);

            System.out.println("user addess successfully");
        }
    }
}
