package com.practice.algorithms.dynamicprogramming;

public class MaximumSumIncreasingSubsequence {

	public int maxSum(int[] arr) {
		int[] max = new int[arr.length];
		int[] seq = new int[arr.length];
		for (int i = 0; i < max.length; i++) {
			max[i] = arr[i];
			seq[i] = i;
		}
		for (int i = 1; i < seq.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (max[j] + arr[i] > max[i]) {
						max[i] = max[j] + arr[i];
						seq[i] = j;
					}
				}
			}
		}
		for (int i = 0; i < max.length; i++) {
			System.out.print(max[i] + " ");
		}
		System.out.println();
		int maxSum = 0;
		for (int i = 0; i < max.length; i++) {
			if (max[i] > maxSum) {
				maxSum = max[i];
			}
		}
		for (int i = 0; i < seq.length; i++) {
			System.out.print(seq[i] + " ");
		}
		System.out.println();
		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSumIncreasingSubsequence miss = new MaximumSumIncreasingSubsequence();
		int arr[] = { 4, 6, 1, 3, 8, 4, 6 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(miss.maxSum(arr));
	}

}
