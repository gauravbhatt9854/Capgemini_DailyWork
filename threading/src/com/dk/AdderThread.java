package com.dk;

public class AdderThread extends Thread {

	int[][] a, b, c;
	int rownum;

	// refactoring the code
	public AdderThread(int[][] a, int[][] b, int[][] c, int rownum) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.rownum = rownum;
	}

	public void run() {
		// a[i][0] ... b[i][0] put in a[i][0]...
		for (int k = 0; k < a[rownum].length; k++) {
			c[rownum][k] = a[rownum][k] + b[rownum][k];
		}
	}

}
