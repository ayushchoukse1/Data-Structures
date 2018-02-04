package com.practice.algorithms.arrays;

public class RotateArray {

	public void reverseByNSteps(int a[], int start, int end) {

		int temp;
		// swap until the array is reversed.
		while (start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// given array
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };

		// length of array
		int length = 7;

		// number of steps to be rotated
		int steps = 2;

		RotateArray object = new RotateArray();
		// Reverse the array from 0 to the m-1 steps for eg- 0 to 1 here.
		object.reverseByNSteps(a, 0, steps - 1);
		// Reverse the remaining array after 2, i.e, 2 to 6th index.
		object.reverseByNSteps(a, steps, a.length - 1);
		// Now reverse the whole array again and print it to console
		object.reverseByNSteps(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
}