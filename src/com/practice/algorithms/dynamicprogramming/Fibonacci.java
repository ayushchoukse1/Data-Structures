package com.practice.algorithms.dynamicprogramming;

public class Fibonacci {

	public void iterative(int n) {
		if (n <= 0) {
			System.out.println(0);
		}
		int[] fib = new int[n];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		for (int i = 0; i < fib.length; i++) {
			System.out.println(fib[i] + " ");
		}
	}

	public static void main(String[] args) {

		Fibonacci fb = new Fibonacci();
		// fb.iterative(10);
	}
}
