package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface Calc 
{
	int add(int a, int b); // public by default only ONE ABSTRACT METHOD
//	int subtract(int a, int b); can not add thid method 
	// default methods
	// static methods
}
interface CalcI 
{
	int sum(int a, int b);
}

class MyCalc implements Calc // control 1
{

	@Override
	public int add(int a, int b) {
		return  a + b;
	}
}

interface Consumer 
{
	public void accept(Object ob);
}
public class LambdaDemo {
	
	public static void main(String[] args) {
		class MyCalc2 implements Calc
		{

			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
			
		}

		
//		Calc c1 = new Calc();// error 
		Calc c1 = new MyCalc();
		int sum = c1.add(6,4);
		
		// system will create a class LambdaDemo$1  Anonymous class
		Calc c2 = new Calc() {
			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		
		Calc c3 = new MyCalc2(); // using inner  class
		c3.add(5, 3);
		
		Calc c4 = (int a, int b) -> { return a + b; };
		Calc c5 = (a, b) -> { return a + b; };
		Calc c6 = (a, b) -> a + b ;
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(34, "Sourav"));
		list.add(new Employee(845, "Shubham"));
		list.add(new Employee(158, "Saurabh"));
		list.add(new Employee(634, "Navneet"));
		list.add(new Employee(304, "Shivam"));
		list.add(new Employee(834, "Sourav"));
		Comparator<Employee> comp = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
//				if(o1.empid > o2.empid) return 1;
//				if(o1.empid < o2.empid) return -1;
//				return 0;
				
				return o1.empid - o2.empid;
				
			}
			
		};
		list.sort(comp);
//		list.sort(new Comparaotr<Employee>() {}); //using anonymous class
		list.sort((e1,e2) ->  e1.empid - e2.empid);
		System.out.println(list);
		
		list.sort((e1, e2) -> e1.name.compareTo(e2.name));
		System.out.println(list);
		
		// Method references 
		CalcI calci = (a,b) -> a + b;
		Calc calc = (a,b) -> a + b;
		
		calc = calci::sum;
		Consumer consumer = System.out::println; 
		consumer.accept("Hello all this is consumer");
		
		
		
		
	}
	

}









