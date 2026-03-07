package basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		// enter roll , enter marks 
		// list all records : 
		// give roll, show me marks : search
		
		FileOutputStream fout = new FileOutputStream("empData.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(new Employee(234, "Aditya"));
		oos.writeObject(new Employee(235, "Shubham"));
		oos.writeInt(987);
		oos.close();
		fout.close();
		System.out.println("data written ");
		
		FileInputStream fin = new FileInputStream("empData.bin");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Object ob1 = ois.readObject();
		Object ob2 = ois.readObject();
		int x = ois.readInt(); // control 2 + L , control + space, F1
		ois.close();
		fin.close();
		
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println("x = " + x);
		
	}

}
