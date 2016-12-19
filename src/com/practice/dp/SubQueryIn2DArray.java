package com.practice.dp;

public class SubQueryIn2DArray {
	int[][] matrix;
	int[][] T;

	/*	
	 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	
		Range Sum Query 2D
		The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
	
		Example:
		Given matrix = [
		  [3, 0, 1, 4, 2],
		  [5, 6, 3, 2, 1],
		  [1, 2, 0, 1, 5],
		  [4, 1, 0, 1, 7],
		  [1, 0, 3, 0, 5]
		]
	
		sumRegion(2, 1, 4, 3) -> 8
		sumRegion(1, 1, 2, 2) -> 11
		sumRegion(1, 2, 2, 4) -> 12
		
		Note:
		You may assume that the matrix does not change.
		There are many calls to sumRegion function.
		You may assume that row1 ≤ row2 and col1 ≤ col2.
		
		*/
	public SubQueryIn2DArray(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		this.matrix = matrix;
		calculateSumMatrix(matrix);
	}

	private void calculateSumMatrix(int[][] matrix) {
		T = new int[matrix.length + 1][matrix[0].length + 1];
		T[1][1] = matrix[0][0];
		for (int j = 2; j < T[0].length; j++) {
			T[1][j] = T[1][j - 1] + matrix[0][j - 1];
		}
		for (int i = 2; i < T.length; i++) {
			T[i][1] = T[i - 1][1] + matrix[i - 1][0];
		}

		for (int i = 2; i < T.length; i++) {
			for (int j = 2; j < T[0].length; j++) {
				T[i][j] = T[i][j - 1] + T[i - 1][j] + matrix[i - 1][j - 1] - T[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1++;
		col1++;
		row2++;
		col2++;

		return (T[row2][col2] - T[row2][col1 - 1] - T[row1 - 1][col2] + T[row1 - 1][col1 - 1]);
	}

	public static void main(String[] args) {

		int[][] input = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		int[][] input1 = { { 2, 0, -3, 4 }, { 6, 3, 2, -1 }, { 5, 4, 7, 3 }, { 2, -6, 8, 1 } };
		SubQueryIn2DArray sq = new SubQueryIn2DArray(input1);
		System.out.println(sq.sumRegion(1, 1, 2, 2));
	}

}
