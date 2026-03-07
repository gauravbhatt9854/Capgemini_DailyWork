package basic;

public class StringAlgo {
	
	public String shift2Chars(String input)
	{
		String end = input.substring(2);
		String start = input.substring(0, 2);
		return end + start; 
	}
	public static void main(String[] args) {
		StringAlgo obj = new StringAlgo();
		System.out.println(obj.shift2Chars("testing"));
	}
}