package com.dk;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAlgoTest {

	static int x;

//	@BeforeAll
//	public static void abdcdefbeforeAll() {
//		// connection to db, make a chat connection, create websocket
//		System.out.println("before all tests db connection");
//	}
//
//	@AfterAll
//	public static void afterAll() {
//		// connection to db, make a chat connection, create websocket
//		System.out.println("after all tests close db connection");
//	}
//
//	@BeforeEach
//	public void setUpTestCase() {
//		System.out.println("before each test clear cache, insert data, remove data, add collection");
//	}
//
//	@AfterEach
//	public void tearDownTestCase() {
//		System.out.println("after each test clear cache, remove data, reset collection");
//	}

	/*
	 * Sachin Mishra SM Sachin Kumar Mishra SM Sachin SN Ananad Kumar Mangal Mehta
	 * AM
	 * 
	 */
	@ParameterizedTest
	@CsvSource(value = { "Hello,lloHe", "program,ogrampr", "java,vaja", "test,stte" })
	public void testshift2CharsCsv(String input, String expected) {
		StringAlgo obj = new StringAlgo();
		System.out.println("testing with " + input + " =>" + expected);
		String actual = obj.shift2Chars(input);
		assertEquals(expected, actual);
	}

	@Test
	@Disabled
	void testShift2Chars() {
		StringAlgo obj = new StringAlgo();
		String input = "Hello";
		String expected = "lloHe";
		String actual = obj.shift2Chars(input);
		assertEquals(expected, actual);

	}

	@Test
	@Disabled
	void testShift2CharsTest2() {
		StringAlgo obj = new StringAlgo();
		String input = "ab";
		String expected = "ab";
		String actual = obj.shift2Chars(input);
		assertEquals(expected, actual);

	}

	@Test
	void testSmallInput() {
		StringAlgo obj = new StringAlgo();
		String input = "a";
		try {
			String actual = obj.shift2Chars(input);
		} catch (Exception e) {
			if (e.getClass() == StringIndexOutOfBoundsException.class) {
				// success
			} else
				fail("exception class is differnt " + e);
		}
	}

	@Test
	void testSmallInput2() {
		StringAlgo obj = new StringAlgo();
		String input = "a";
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			String actual = obj.shift2Chars(input);
		});

	}

	// From DB value received
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testFromDB() {
		StringAlgo obj = new StringAlgo();
		String expected = "From DB value received";
		String actual = obj.getFromDB();
		assertEquals(expected, actual);

	}

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	public void sortTest() {
//		PawanAlgo algo = new PawanAlgo();
		int a[] = new int[1000000];
		// populate random int
//		algo.sort(a);
	}

}
