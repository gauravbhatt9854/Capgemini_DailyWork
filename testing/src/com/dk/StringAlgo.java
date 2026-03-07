package com.dk;

public class StringAlgo {

	// write a function to shift first 2 chars at last of string
	// hello -> llohe
	// program -> ogrampr
	// few questions : can input be null
	// length of input >= 2 or not ?
	// what to return in case of exception
	/**
	 * 
	 * @param str : non null string of lenth min 2
	 * @return returns first 2 chars shifted to last of the string
	 * @throws For null input : NullPointerException For input < length(2) returns
	 *             StringIndexOutOfBoundsException
	 */

	public String shift2Chars(String str) {
		String start = str.substring(0, 2);
		String end = str.substring(2);

		return end + start;
	}

	public String getFromDB() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "From DB value received";
	}

	public static void main(String[] args) {
		StringAlgo obj = new StringAlgo();
		String output = obj.shift2Chars("Hello");
		System.out.println(output);
		output = obj.shift2Chars("A");
		output = obj.shift2Chars(null);

		System.out.println(output);
	}

}
