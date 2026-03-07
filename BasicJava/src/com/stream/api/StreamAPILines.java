package com.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.igate.labs.EmployeeRepository;

public class StreamAPILines {
	public static void main(String[] args) {
		List<String> list = List.of("this is a line in java", "we will convert each line to words",
				"using stream api is easy", "lambda expressions are used a lot");
		// 1 first word of every line
		List<String> firstwords = list.stream().map(line -> line.split(" ")[0]).collect(Collectors.toList());
		System.out.println(firstwords);

		// map of lines with length
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(line -> line, line -> line.length()));
		System.out.println(map);
		// print lines with more than 5 words
		list.stream().filter(line -> line.split(" ").length > 5).forEach(System.out::println);

		// stream of words in each line
		List<String> words = list.stream().flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.toList());
		System.out.println(words);

		Optional<String> optString = list.stream().reduce((s1, s2) -> s1 + " " + s2);
		System.out.println(optString.get());

		Optional<Double> sumSal = EmployeeRepository.getEmployees().stream().map(e -> e.getSalary())
				.reduce((s1, s2) -> s1 + s2);
		double sum = EmployeeRepository.getEmployees().stream().mapToDouble(e -> e.getSalary()).sum();
		System.out.println(sumSal.get());

	}

}
