package com.practice.dp;

public class MaximumSubSquareMatrix {

	public int findMaxSubSquare(int[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		int max = 0;
		int[][] T = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < T.length; i++) {
			T[i][0] = 0;
			T[0][i] = 0;
		}
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == 0) {
					T[i][j] = 0;
				} else {
					T[i][j] = 1+ Math.min(T[i][j - 1], Math.min(T[i - 1][j - 1], T[i - 1][j]));
					max = T[i][j] > max ? T[i][j] : max;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 1 } };
		MaximumSubSquareMatrix mssm = new MaximumSubSquareMatrix();
		System.out.println(mssm.findMaxSubSquare(arr));
		System.out.println(mssm.findMaxSubSquare(null));
	}

}
