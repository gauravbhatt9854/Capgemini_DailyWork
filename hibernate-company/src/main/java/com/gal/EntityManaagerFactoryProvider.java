package com.gal;

import java.sql.Date;
import java.util.List;

import com.gal.model.Department;
import com.gal.model.Employee;
import com.gal.model.Item;
import com.gal.model.Parking;
import com.gal.model.Project;
import com.gal.model.Quotation;
import com.gal.model.Vendor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

// singleton design pattern : emf : one , em : many 
public class EntityManaagerFactoryProvider {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("company_db_pu");
		}
		System.out.println(emf);
		return emf;

	}

	public static EntityManager getEntityManager() {
		if (emf == null)
			getEntityManagerFactory();
		if (em == null || !em.isOpen())
			em = emf.createEntityManager();
		return em;
	}

	public static void closeConnections() {
		getEntityManager().close();
		getEntityManagerFactory().close();
	}

	public static void main(String[] args) {
		EntityManager em = getEntityManager();

//		EmployeeDao dao = new EmployeeDao();
//		Employee emp208 = dao.getEmployee(208);
//		System.out.println(emp208);
//		emp208.setLast_name("Kumar Sharma");
//		emp208.setJob_title("SW Developer");
//		getEntityManager().getTransaction().begin();
//		getEntityManager().persist(emp208);
//		getEntityManager().getTransaction().commit();
//		Date hire_date = Date.valueOf("2020-04-05");

		// detached entity / transient entity provided

//		Employee emp = new Employee(hire_date, 3000.0, 208, 200, 20, "98655421", "Aditya", "Kumar Sharma",
//				"aditya@gmail.com", "SW Developer");

//		Steven	King	SKING	515.123.4567	1997-06-17	President	24000		10

//		primary key using identtity 
		Item item = new Item(0, "electronics", "laptop", 120000.0);
		em.getTransaction().begin();
//		em.persist(item);
		Parking p1 = new Parking(0, 0, "S001");
		Parking p2 = new Parking(0, 0, "S002");
//		em.persist(p1);
//		em.persist(p2);

		Vendor v1 = new Vendor(0, "GoodOne Enterprices");
//		em.persist(v1);

		System.out.println(p1);
		System.out.println(p2);
//		System.out.println(item);

		Quotation q = new Quotation();
		q.setQdate(Date.valueOf("2025-05-08"));
		q.setCost(650000.0);
//		em.persist(q);

		em.getTransaction().commit();

		Query query = em.createQuery("select e from Employee e"); // employee class
		List<Employee> list = query.getResultList();
		for (Employee e : list)
			System.out.println(e);

		System.out.println();
		Department dep = em.find(Department.class, 10);
		List<Employee> employees = dep.getEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}

		Employee emp8 = em.find(Employee.class, 208);
		System.out.println(emp8.getInterests());

		em.getTransaction().begin();
//		Project pr1 = new Project(Date.valueOf("2020-04-12"), Date.valueOf("2024-05-08"), "indigo", 8500000.0);
//		Project pr2 = new Project(Date.valueOf("2021-04-12"), Date.valueOf("2026-05-08"), "sbi", 8505000.0);
//		Project pr3 = new Project(Date.valueOf("2018-04-12"), Date.valueOf("2023-05-08"), "aramco", 7500000.0);
//		Project pr4 = new Project(Date.valueOf("2026-01-12"), Date.valueOf("2032-05-08"), "hal", 10500000.0);

//		em.persist(pr1);
//		em.persist(pr2);
//		em.persist(pr3);
//		em.persist(pr4);
		Project p1001 = em.find(Project.class, 1001);
		System.out.println("employees on project 1001 ");
		List<Employee> employees2 = p1001.getEmployees();
		for (Employee e : employees2) {
			System.out.println(e.getFirst_name());
		}
//		p1001.setManager(em.find(Employee.class, 124));
//		Project p1002 = em.find(Project.class, 1002);
//		p1002.setManager(em.find(Employee.class, 205));

		em.getTransaction().commit();
		closeConnections();
	}

}
