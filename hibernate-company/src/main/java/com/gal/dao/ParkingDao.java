package com.gal.dao;

import com.gal.EntityManaagerFactoryProvider;
import com.gal.model.Parking;

import jakarta.persistence.EntityManager;

// using EntityManager , JDBC
// press control , to go back alt <- , go forward alt -> 
public class ParkingDao {

	public Parking getParking(int parkingid) {
		EntityManager em = EntityManaagerFactoryProvider.getEntityManager();
		Parking parking = em.find(Parking.class, parkingid);
		return parking;
	}

	public Parking addParking(Parking parking) {
		EntityManager em = EntityManaagerFactoryProvider.getEntityManager();
		em.getTransaction().begin();
		em.persist(parking); // create connection, create query,
		em.getTransaction().commit();
		return parking;
		// create preparedStatement, fill up ?
		// call executeupdate
	}

}
