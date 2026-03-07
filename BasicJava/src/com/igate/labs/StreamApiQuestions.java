package com.igate.labs;

import java.util.List;
import java.util.Optional;

import com.igate.streamlab.Department;
import com.igate.streamlab.Employee;

public class StreamApiQuestions {

	public static void main(String[] args) {
		List<Department> departments = EmployeeRepository.getDepartments();
		List<Employee> employees = EmployeeRepository.getEmployees();
//		1.	Find out the sum of salary of all employees. 
		// 2 special stream IntStream LongStream DoubleStream
		double sum = employees.stream().mapToDouble(emp -> emp.getSalary()).sum();
		System.out.println("sum = " + sum);

//		2.	List out department names and count of employees in each department. 

//		3.	Find out the senior most employee of an organization. 
		Optional<Employee> optMin = employees.stream().min((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate()));
		System.out.println(optMin.get());
//		4.	List employee name and duration of their service in months and days. 
		
//		5.	Find out employees without department.
		
//		6.	Find out department without employees.
//		7.	Find departments with highest count of employees.
//		8.	List employee name, hire date and day of week on which employee has started. 
//		9.	List employee name, hire date and day of week for employee started on Friday. (Hint:  Accept the day name for e.g. FRIDAY and list all employees joined on Friday)
//		10.	List employee’s names and name of manager to whom he/she reports. Create a report in format “employee name reports to manager name”.
			employees.stream().
		//		11.	List employee name, salary and salary increased by 15%. 

//		12.	Find employees who didn’t report to anyone (Hint: Employees without manager)  
//		13.	Create a method to accept first name and last name of manager to print name of all his/her subordinates.  

	}

}
