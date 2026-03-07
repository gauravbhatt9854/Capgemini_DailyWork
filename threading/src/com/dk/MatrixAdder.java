package com.dk;

public class MatrixAdder {

	public void add(int[][] a, int[][] b, int[][] c) {
		//
		for (int i = 0; i < a.length; i++) {
			AdderThread t = new AdderThread(a, b, c, i);
			t.start();
		}
	}

}
