package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;



class MyInts
{
	public int first()
	{
		return (int) System.currentTimeMillis() % 100;
	}
	public int second()
	{
		return new Random().nextInt(300);
	}
}

public class LambdaInBuiult {
	public static void main(String[] args) {
		Consumer<String> consumer = (str) -> {
			System.out.println("this is a cosumer");
			System.out.println("this is consuming " + str);
			
		};
		consumer.accept("SPRING FRAMEWORD");
		List<Integer> list = List.of(4,5,6,7,23,45,56,4);
		list.forEach((x) -> System.out.println("consuming " + x));
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("consuming " + t);
			} 
		}); 
		
		list.forEach(System.out::println);
		
		Function<String,Integer> fun2 = new Function<>() {

			@Override
			public Integer apply(String t) {
				
				return null;
			} } ;
		Function<String,Integer> fun1 = (str) -> str.length();
		Integer len = fun1.apply("Ayush Kumar");
		// write a lambda to get first 2 chars in upper case of the string using "Function" as 
		// functional interface 
		Function<String, String> fun3 = (str) -> str.substring(0, 2).toUpperCase();
		String nick = fun3.apply("Utkarsh Bhola");
		System.out.println(nick);
		
		Supplier<Integer> supplier = new Supplier<>() {

			@Override
			public Integer get() {
				return new Random().nextInt(400);
			}};
		Random random = 	new Random();
		supplier = () -> random.nextInt(400);
		for(int i = 1; i<= 10; i++)
		{
			System.out.println(supplier.get());
		}
		supplier = random::nextInt; 
//		supplier.get = random.nextIn ;
		
		MyInts obj = new MyInts();
		supplier = obj::first;
		supplier = obj::second;
		
		Predicate<String> pred = new Predicate<>() {

			@Override
			public boolean test(String t) {
				return t.length()>=10;
			}};
		pred = (str) -> str.length()>= 10;
		Integer[] ar = { 34,46,23,57,66,34,54679,786,54,23,65,9,5,634};
		List<Integer> list2 = new ArrayList<>();
		list2.addAll(Arrays.asList(ar));
		list2.removeIf(x -> x > 100);
		System.out.println(list2);
		
		
		
	}

}










