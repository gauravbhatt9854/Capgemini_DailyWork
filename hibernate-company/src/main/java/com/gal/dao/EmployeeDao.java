package com.gal.dao;

import com.gal.EntityManaagerFactoryProvider;
import com.gal.model.Employee;

import jakarta.persistence.EntityManager;

// using EntityManager , JDBC
public class EmployeeDao {

	public Employee getEmployee(int empid) {
		EntityManager em = EntityManaagerFactoryProvider.getEntityManager();
		Employee employee = em.find(Employee.class, empid);
		return employee;
	}

	public Employee addEmployee(Employee emp) {
		EntityManager em = EntityManaagerFactoryProvider.getEntityManager();
		em.persist(emp); // it will save data only if a transaction is going on
		return emp;
	}

	public Employee updateEmployee(Employee emp) {
		EntityManager em = EntityManaagerFactoryProvider.getEntityManager();
		em.persist(emp); // it will save data only if a transaction is going on
		return emp;
	}

}
