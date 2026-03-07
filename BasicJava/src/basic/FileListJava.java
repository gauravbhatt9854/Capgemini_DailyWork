package basic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileListJava {
	
	public static void main(String[] args) {
		// read a directory name from user
				// list all java files only in this folder
				// sort them as per their length in descending order and display
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.println("enter folder ");
			String folder = sc.nextLine();
			File dir = new File(folder);
			if(! dir.exists() || ! dir.isDirectory())
			{
				System.out.println("can not proceed with this dir");
				return;
			}
			File[] listFiles = dir.listFiles();
			List<File> files = new ArrayList<>();
			for(File f :listFiles)
			{
				if(f.isFile() && f.getName().endsWith(".java"))
					files.add(f);
			}
			Collections.sort(files, (a,b) -> (int) (b.length() - a.length()) );
			for(File f : files)
			{
				System.out.println(f.length() + "\t" + f.getName());
			}
			
		}
		finally
		{
			sc.close();
		}
	}

}
//
//Hello.java  1
//MapDemo.java 4
//Sliding.java 40







