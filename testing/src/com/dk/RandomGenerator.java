package com.dk;

public class RandomGenerator {

	public int[] getTenRandoms() {
		int[] ar = new int[10];
		for (int i = 0; i < 10; i++) {
			ar[i] = i + 1;
		}
		return ar;

	}

}
