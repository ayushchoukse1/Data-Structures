package com.practice.algorithms.ctc.moderate;

public class NumberMax {
	public int getMax(int a, int b) {
		int k = sign(a - b);
		int q = flip(k);
		return a * k + b * q;
	}

	public int flip(int a) {
		return 1 ^ a;
	}

	public int sign(int a) {
		return flip((a >> 31) & 0x1);
	}

	public static void main(String[] args) {
		NumberMax nm = new NumberMax();
		System.out.println(nm.getMax(5, 1657));
	}
}
