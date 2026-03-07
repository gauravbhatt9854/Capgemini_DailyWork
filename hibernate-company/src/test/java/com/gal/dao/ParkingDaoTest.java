package com.gal.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gal.EntityManaagerFactoryProvider;
import com.gal.model.Parking;

class ParkingDaoTest {

	@Test
	void testGetParking() {
		ParkingDao dao = new ParkingDao();
		Parking parking = dao.getParking(1);
//		Steven	King	SKING	515.123.4567	1997-06-17	President	24000		10
//		assertNull(parking);
	}

	@Test
	void testaddParking() {
		Parking obj = new Parking(1, 0, "A001");
		ParkingDao dao = new ParkingDao();
		Parking parking = dao.addParking(obj);
//		Steven	King	SKING	515.123.4567	1997-06-17	President	24000		10
		assertNotNull(parking);
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
