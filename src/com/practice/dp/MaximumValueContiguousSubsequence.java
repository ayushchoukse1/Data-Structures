package com.practice.dp;

public class MaximumValueContiguousSubsequence {

	public int mcs(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int maxSum = A[0];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = Math.max((sum + A[i]), A[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaximumValueContiguousSubsequence mcs = new MaximumValueContiguousSubsequence();
		// int[] a = { 1, -3, 4, -2, -1, 6 };
		int[] a = { 1, -3, 4, -2, -1, 6, 1, -3, 4, -2, -1, 6, 1, -3, 4, -2, -1, 61, -3, 4, -2, -1, 6 };
		System.out.println(mcs.mcs(a));
	}

}
