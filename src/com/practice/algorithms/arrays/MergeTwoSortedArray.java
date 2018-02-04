package com.practice.algorithms.arrays;

public class MergeTwoSortedArray {

	/*
	 * There are two sorted arrays. First one is of size m+n containing only m
	 * elements. Another one is of size n and contains n elements. Merge these
	 * two arrays into the first array of size m+n such that the output is
	 * sorted.
	 */

	public int[] mergeSortedArrays(int a[], int b[]) {
		// Initialize new array of size equal to sum of lengths of a and b
		int m = a.length;
		int n = b.length;

		int temp[] = new int[m + n];

		// If a is empty return b
		if (a == null)
			return b;

		// If b is empty return a
		if (b == null)
			return a;

		// counter for 'a'
		int i = 0;

		// counter for 'b'
		int j = 0;

		// counter for 'temp'
		int k = 0;

		// compare and insert into temp until the temp array reaches its size.
		while (k < (m + n)) {
			// compare if counter is smaller than length of 'a' then we are not
			// at the end
			// compare integers from 'a' and 'b'. if element in 'a' is smaller
			// take from 'a' and increment counters.
			if ((i < m && a[i] <= b[j]) || (j == n)) {
				temp[k] = a[i];
				i++;
				k++;
			} else {
				// else take from 'b' and increase the respective counters
				temp[k] = b[j];
				j++;
				k++;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		// Lets take two sorted arrays.
		int a[] = { 1, 2, 4, 5, 7, 9 };
		int b[] = { 3, 6, 8, 10, 11 };

		MergeTwoSortedArray object = new MergeTwoSortedArray();

		int temp[] = object.mergeSortedArrays(a, b);

		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}
}
