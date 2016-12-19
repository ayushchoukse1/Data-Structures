package com.practice.dp;

public class MatrixProductParanthesization {
	public int mpp(int[] arr) {

		int[][] T = new int[arr.length][arr.length];
		// int[][] S = new int[arr.length][arr.length];
		int q = 0;
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {

				int j = i + l;
				T[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = T[i][k] + T[k][j] + (arr[i] * arr[k] * arr[j]);

					if (q < T[i][j]) {
						// T[i][j] = q;
						T[i][j] = q;
					}
				}
			}
		}
		return T[0][arr.length - 1];
	}

	public int findCost(int arr[]) {
		int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				temp[i][j] = 1000000;
				for (int k = i + 1; k < j; k++) {
					q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
				}
			}
		}
		return temp[0][arr.length - 1];
	}

	public static void main(String[] args) {
		MatrixProductParanthesization mpp = new MatrixProductParanthesization();
		int[][] array = { { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 } };
		int[] a = { 4, 2, 3, 5, 3 };
		System.out.println(mpp.mpp(a));
		System.out.println(mpp.findCost(a));
	}
}
