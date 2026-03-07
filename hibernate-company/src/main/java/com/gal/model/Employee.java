package com.gal.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// javax.persistence.Entity : Oracle Standard making open source community java

@Entity
@Table(name = "employee")
public class Employee {

	// without id : there is no entity

	@Column(name = "hire_date")
	private Date hire_date;

	private Double salary;
	@Id
	private int employee_id;

	private Integer manager_id;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
//	private Integer department_id;

	@ElementCollection
	@CollectionTable(name = "interest", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "field")
	private List<String> interests;

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	private String phone_number;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String first_name; // firstName e.firstName
	private String last_name;
	private String email;
	private String job_title;
	private String address;

	public Employee() {
		super();
	}

	public Employee(Date hire_date, Double salary, int employee_id, Integer manager_id, Integer department_id,
			String phone_number, String first_name, String last_name, String email, String job_title) {
		super();
		this.hire_date = hire_date;
		this.salary = salary;
		this.employee_id = employee_id;
		this.manager_id = manager_id;
//		this.department_id = department_id;
		this.phone_number = phone_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.job_title = job_title;
	}

	@Override
	public String toString() {
		return "Employee [hire_date=" + hire_date + ", salary=" + salary + ", employee_id=" + employee_id
				+ ", manager_id=" + manager_id + ", phone_number=" + phone_number + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", job_title=" + job_title + ", address=" + address
				+ "]";
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

//	public Integer getDepartment_id() {
//		return department_id;
//	}
//
//	public void setDepartment_id(Integer department_id) {
//		this.department_id = department_id;
//	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

}
