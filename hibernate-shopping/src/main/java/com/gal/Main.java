package com.gal;

import com.gal.model.Customer;

import com.gal.model.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class Main {

    private final static EntityManager em = EntityManaagerFactoryProvider.getEntityManager();


	public static void main(String[] args) {
		Customer customer = em.find(Customer.class, 101);

		em.getTransaction().begin();
		Customer c = new Customer();
		em.persist(c);

		em.getTransaction().commit();

	}

}
