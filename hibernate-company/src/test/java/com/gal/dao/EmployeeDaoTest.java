package com.gal.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gal.EntityManaagerFactoryProvider;
import com.gal.model.Employee;

class EmployeeDaoTest {

	@Test
	void testGetEmployee() {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getEmployee(208);
//		Steven	King	SKING	515.123.4567	1997-06-17	President	24000		10
		assertNotNull(employee);
		System.out.println(employee);
		assertEquals("Steven", employee.getFirst_name());
	}

	@Test
	// @Transactional
	void testUpdateEmployee() {

		EmployeeDao dao = new EmployeeDao();
		new Employee();
		Date hire_date = Date.valueOf("2020-04-05");

		Employee emp = new Employee(hire_date, 3000.0, 208, 200, 20, "98655421", "Aditya", "Kumar Sharma",
				"aditya@gmail.com", "SW Developer");

//		Steven	King	SKING	515.123.4567	1997-06-17	President	24000		10
		EntityManaagerFactoryProvider.getEntityManager().getTransaction().begin();
		dao.updateEmployee(emp); // if you are not in a transaction, hibernate will not update DB
		assertNotNull(emp);
		System.out.println(emp);
		EntityManaagerFactoryProvider.getEntityManager().getTransaction().commit();

//		assertEquals("Steven", employee.getFirst_name());
	}

	@BeforeAll
	public static void openConnections() {
		System.out.println("opening connnections ");
		EntityManaagerFactoryProvider.getEntityManager();
	}

	@AfterAll
	public static void closeConnnection() {
		System.out.println("closing connnections ");
		EntityManaagerFactoryProvider.getEntityManager().close();
		EntityManaagerFactoryProvider.getEntityManagerFactory().close();
	}

}
