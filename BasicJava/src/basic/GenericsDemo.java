package basic;

class StkGeneral<T>
{
	Object a[] = new Object[10];
	int top = -1;
	
	public void push(T x)
	{
		a[++top] = x;
	}
	T pop()
	{
		return (T) a[top--];
	}
}

public class GenericsDemo {
	public static void main(String[] args) {
		StkGeneral<Integer> s1 = new StkGeneral<>();
		s1.push(34); s1.push(55); 
		StkGeneral<String> s2 = new StkGeneral<>();
		s2.push("Bhavya");
		s2.push("Vaduni");
		s2.push("Ayushi");
		
	}
	

}
