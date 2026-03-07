package basic;

public class Stk {
	
	int[] a= new int[10];
	int top = -1;
	
	void push(int x)
	{
		if(top == a.length-1)
		{
			System.out.println("overflow");
			return;
		}
	}
	int pop() throws Exception
	{
		if(top == -1)
		{
			System.out.println("underflow");
//			return 0; // i want to inform about underflow  2 3 0 3 4
			Exception e = new Exception("underflow");
			throw e;
		}
		else
			return a[top--];
	}

}
