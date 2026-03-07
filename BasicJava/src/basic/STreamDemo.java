package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class STreamDemo {
	
	public static void main(String[] args) {
		List<Integer> list = List.of(23,23,45,34,65,4,46,78,54,23,56,7,65,43, 45, 46,43); // control 1, control + shift + O
		Stream<Integer> stream = list.stream();
		boolean allMatch = stream.allMatch(x -> x >=40);
		System.out.println("all greater thn 40 " + allMatch);
		
		boolean anyMatch = list.stream().anyMatch(x -> x >=75);
		System.out.println("any above 75 " + anyMatch);
		System.out.println( list.stream().count() );
		list.stream().distinct().forEach(System.out::println);
		System.out.println();
		list.stream().filter(x -> x>=40).forEach(System.out::println);
		int passed = 0;
		for(int i = 0 ; i<list.size(); i++)
		{
			if(list.get(i) >= 40) passed++;
		}
		
		Stream<Integer> filter = list.stream().filter(x -> x>=40);
		Optional<Integer> any = filter.findAny();
		System.out.println();
		list.stream()
			.filter(x -> x>=40)
			.map(x -> x/10.0)
			.forEach(System.out::println);
		
		Integer[] ar = { 234,43,45,6,65,45,67,654,34,576,88,5654};
		Arrays.stream(ar);
		
	}

}








