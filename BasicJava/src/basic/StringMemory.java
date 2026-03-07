package basic;

import java.util.Scanner;

public class StringMemory {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		String s3 = "Hello";
		String s4 = "Hello";
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);	
		
		System.out.println(System.in.getClass());
		
		
	}

}
