package basic;

import java.io.File;
import java.io.IOException;

public class FilesLIst {
	
	public static void main(String[] args) {
		// read a directory name from user
		// list all java files only in this folder
		// sort them as per their length in descending order and display
		
		File file = new File("src/basic/Employee.java") ; // about the information of file NOT DATA
		System.out.println("exists " + file.exists());
		System.out.println("isfile " + file.isFile());
		
		System.out.println("idDir " + file.isDirectory());
		System.out.println("length " + file.length());
		System.out.println("can read " + file.canRead());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		
		File dir = new File(".");
		System.out.println("exists " + dir.exists());
		System.out.println(dir.isDirectory());
		String[] list = dir.list();
		for(String name : list)
			System.out.println(name);
		
		File newDir = new File("d:/galgotias");
		if(! newDir.exists())
			try {
				boolean created = newDir.mkdir();
				System.out.println("Dir created " + created);
				
			} 
		catch(SecurityException e)
		{
			System.out.println("can not create dir");
		}
		
		
	}

}
