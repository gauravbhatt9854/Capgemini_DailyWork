package basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MarksDB {
	
	String filename;
	ObjectOutputStream ois = null;
	FileOutputStream fout = null;
	ObjectOutputStream oos = null;

	public MarksDB(String filename) throws IOException {
		super();
		this.filename = filename;
		fout = new FileOutputStream(filename,true);
		oos = new ObjectOutputStream(fout);
	}
	public void printAll() throws IOException
	{
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fin);
		while(ois.available() > 0)
		{
			int roll = ois.readInt();
			int marks = ois.readInt();
			System.out.println(roll + "\t" + marks);
		}
		ois.close();
		fin.close();
	}
	public void writeData(int roll, int marks) throws IOException
	{
		//check if duplicate else
		
		oos.writeInt(roll);
		oos.writeInt(marks);
		oos.flush();
		fout.flush();
		
	}

}
