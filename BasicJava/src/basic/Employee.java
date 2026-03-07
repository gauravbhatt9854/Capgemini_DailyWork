package basic;

import java.io.Serializable;
//LOMBOK @AllArgConstructor @

public class Employee implements Serializable{
	
	transient public  long time; // will not be written on to file 
	static int value = 34;
	
	public int empid;
	public String name;
	public Employee(int empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + "]";
	}
	
	
	

}
