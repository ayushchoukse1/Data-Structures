package com.practice.algorithms.misc;

public class OddOneOut {
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 *
	 */
	public static int singleNumber(int[] array) {
		/* The key to solve this problem is bit manipulation. XOR will return 1
		 only on two different bits. So if two numbers are the same, XOR will
		 return 0. Finally only one number left.
		*/
		int x = 0;
		for (int a : array) {
			x = x ^ a;
		}
		return x;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 4, 5, 5, 4, 3, 6, 6, 7, 7, 8, 9, 8, 9 };
		System.out.println(singleNumber(array));
	}

}
