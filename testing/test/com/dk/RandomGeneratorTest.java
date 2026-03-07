package com.dk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

//	@Test
	@RepeatedTest(3)
	void testGetTenRandoms() {
		RandomGenerator generator = new RandomGenerator();
		int[] ar = generator.getTenRandoms();
		assertEquals(10, ar.length);
		for (int i = 0; i < 10; i++) {
			assertTrue(ar[i] >= 1 && ar[i] <= 10);
		}
		// Stream API
		boolean allMatch = Arrays.stream(ar).allMatch(x -> x >= 1 && x <= 10);
		assertTrue(allMatch);
		boolean anyMatch = Arrays.stream(ar).anyMatch(x -> x < 1 || x > 10);
		assertFalse(anyMatch);

	}

}
