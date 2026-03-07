package basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class StringAlgoTest2 {

	@ParameterizedTest
	@CsvSource(value = { "testing:stingte", "good:odgo" }, delimiter = ':')
	@Order(value = 1)
	void testShift2Chars(String input, String expected) {
		String actual = new StringAlgo().shift2Chars(input);
		System.out.println(input + ":" + expected + ":" + actual);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@MethodSource(value = "stringsForShifting")
	@Order(value = 4)
	void testShift2CharsMethodSource(String input, String expected) {
		String actual = new StringAlgo().shift2Chars(input);
		System.out.println(input + ":" + expected + ":" + actual);
		assertEquals(expected, actual);
	}

	public static Stream<Arguments> stringsForShifting() {
		return Stream.of(Arguments.of("method", "thodme"), Arguments.of("spring", "ringsp"));
	}

//	public static Stream<Arguments> separator(String str)
//	{
//		String[] args = str.split(":");
//		return 
//	}

}
