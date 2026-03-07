package basic;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
//		r 
//		w 
//		a 
//		r+ will not delete data 
//		w+ will delete data 
//		a+ reading /write , do not dlete, start with writing at the end 
//		
		RandomAccessFile file = new RandomAccessFile("data.txt","r");
//		for(int i= 1 ; i<250; i++)
//		{
//			int j = file.read();
//			System.out.print((char) j);
//			if(i %5 == 0) file.skipBytes(3);
//			
//		}
		// Print last 2 bytes of the file 
		file.seek(file.length() - 2);
		System.out.println((char) file.read() +"" + (char) file.read());
		
	}

}
