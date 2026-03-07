package com.dk;

public class MyAlgo {

	StringAlgo stringAlgo;

	public MyAlgo(StringAlgo stringAlgo) {
		super();
		this.stringAlgo = stringAlgo;
	}

	public String useAlgo(String input) {
		System.out.println("running app");
		String answer = stringAlgo.shift2Chars(input);
		System.out.println("answer:" + answer);
		return answer;
	}

}
