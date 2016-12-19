package com.practice.dp;

public class SubsetSum {

	public boolean checkSubset(int[] arr, int sum) {
		boolean[][] T = new boolean[arr.length + 1][sum + 1];

		for (int i = 0; i < T.length; i++) {
			T[i][0] = true;
		}
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - arr[i - 1] >= 0) {
					T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];

				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		return T[arr.length][sum];

	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 7, 8 };
		int sum = 11;
		SubsetSum ss = new SubsetSum();
		System.out.println(ss.checkSubset(arr, sum));
	}

}
