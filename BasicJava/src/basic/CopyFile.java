package basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CopyFile {
	public static void main(String[] args) throws IOException {
		copyFile("data.txt", "dataCopy.txt");
		copyHalfCharsFile("data.txt", "dataCopy2.txt");
		copyHalfLinesFile("data.txt", "dataCopy2.txt");
		copyHalfWordsEachLine("data.txt", "dataCopy3.txt");
		
	}
	public static void copyFile(String inputFile,  String outputFile)throws IOException {

		FileInputStream fin = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		
		int ch = 0;
		while(ch != -1)
		{
			ch = fin.read();
			if(ch == -1) break;
			fout.write(ch);
		}
		fin.close();
		fout.close();
		System.out.println("File copied");
		
	}
	public static void copyHalfWordsEachLine(String inputFile,  String outputFile)throws IOException {

		FileInputStream fin = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		
		int ch = 0;
		String line = br.readLine();
		while(line != null)
		{
			fout.write((halfWords(line)+"\n").getBytes());
			line = br.readLine();
			
		}
		br.close();
		fin.close();
		fout.close();
		System.out.println("File copied");
		
	}
	private static String halfWords(String line) {
	
//		line.split("[ ]+");
		String[] words = line.split("\\s+");
		String answer = "";
		for(int i = 0 ;i< words.length; i+= 2)
		{
			answer = answer + words[i] + " ";
		}
		return answer;
	}
	public static void copyHalfLinesFile(String inputFile,  String outputFile)throws IOException {

		FileInputStream fin = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		
		int ch = 0;
		String line = br.readLine();
		while(line != null)
		{
			fout.write((line+"\n").getBytes());
			line = br.readLine();
			if(line !=null)
			line = br.readLine();
			
		}
		br.close();
		fin.close();
		fout.close();
		System.out.println("File copied");
		
	}

	public static void copyHalfCharsFile(String inputFile,  String outputFile)throws IOException {

		FileInputStream fin = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fout = new FileOutputStream(outputFile);
		
		int ch = 0;
		while(ch != -1)
		{
			ch = fin.read();
			if(ch == -1) break;
			fout.write(ch);
			ch = fin.read();
		}
		fin.close();
		fout.close();
		System.out.println("File copied");
		
	}


}
