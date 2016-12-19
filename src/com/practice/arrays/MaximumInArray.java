package com.practice.arrays;

public class MaximumInArray {

	public int getMax(int[] a) {
		// Assume that the first element of array is the maximum array
		int max = a[0];

		// now compare it with the remaining elements.
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	public static void main(String[] ar) {
		int a[] = { 1, 2, 3, 4, 15, 6, 7 };
		MaximumInArray obj = new MaximumInArray();
		System.out.println(obj.getMax(a));
	}
}