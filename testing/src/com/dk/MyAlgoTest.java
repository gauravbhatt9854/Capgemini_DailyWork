package com.dk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MyAlgoTest {

	MyAlgo myAlgo;

	@Test
	void testUseAlgo() {
		StringAlgo mock = Mockito.mock(StringAlgo.class);
		when(mock.shift2Chars(anyString())).thenReturn("lloHe");
		myAlgo = new MyAlgo(mock);
		String answer = myAlgo.useAlgo("testing with mockito");
		assertEquals("lloHe", answer);

	}

}
