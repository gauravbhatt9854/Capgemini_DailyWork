package basic;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class PictureFormatExeption extends Exception 
{
	
}
public class ExceptionDemo {
	public static void main(String[] args) {
		readIntAndSum();
		
	}
	private static void readIntAndSum() {
		Scanner sc = new Scanner(System.in);
		int s= 0;
		try
		{
			for(int i = 1; i<= 5; i++)
			{
				try
				{
					int x= sc.nextInt();
					s = s + x;
				}
				catch(InputMismatchException e)
				{
					System.out.println("input mismatch");
					sc.next(); //read and ignore the element
					i--;
				}
			}
			System.out.println("sum = " + s);
			
		}
		catch(NoSuchElementException | IllegalStateException e)
		{
			System.out.println("input ended , sum can not be calculated");
		}
		catch(Exception e)
		{
			System.out.println("some error occured " + e);
		}
		finally
		{
			sc.close();
		}
		
	}
	public static void uploadPic()
	{
		//write a program to read 5 integers and calculate the sum
		// user can enter wrong data like abc
		// you have to read 5 integers till the time these are entered
		
		try
		{
		System.out.println("upload pic");
		PictureFormatExeption e = new PictureFormatExeption();
		throw e;
		// ....
		}
		catch(PictureFormatExeption e)
		{
			System.out.println("size or format not correct");
		}
		catch(Exception e)
		{
			System.out.println("some other error occured");
		}
		finally 
		{
			// either finally or catch or both
		}
	}

}
