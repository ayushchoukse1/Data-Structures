package com.practice.algorithms.ctc.moderate;

import java.util.Arrays;

public class SmallestDifference {
	public int diff(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null) {
			return -1;
		}
		int diff = Integer.MAX_VALUE;
		int[] array1 = arr1;
		int[] array2 = arr2;
		Arrays.sort(array1);
		Arrays.sort(array2);
		int a = 0;
		int b = 0;
		while (a < array1.length && b < array2.length) {
			if (Math.abs(array1[a] - array2[b]) < diff) {
				diff = Math.abs(array1[a] - array2[b]);
			}
			if (array1[a] < array2[b]) {
				a++;
			} else {
				b++;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 11, 15 };
		int[] arr2 = { 4, 12, 19, 23, 127, 135 };
		SmallestDifference sd = new SmallestDifference();
		System.out.println(sd.diff(arr1, arr2));
	}

}
