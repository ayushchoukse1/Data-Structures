package com.practice.algorithms.arrays;

public class SwapNumberWithoutExtraSpace {
	public static int[] num = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };

	public static void main(String[] args) {

		int c = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				swap(num[c], num[i]);
				c++;
			}
		}
		for (int k : num) {
			System.out.print(" " + k);
		}
	}

	public static void swap(int i, int j) {
		num[i] = num[i] + num[j];
		num[j] = num[i] - num[j];
		num[i] = num[i] - num[j];
	}

}
