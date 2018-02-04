package com.practice.algorithms.dynamicprogramming;

public class MinimumCostPathMatrix {

	public int minCost(int[][] cost) {
		int[][] T = new int[cost.length][cost[0].length];
		T[0][0] = cost[0][0];
		for (int i = 1; i < T[0].length; i++) {
			T[0][i] = cost[0][i] + T[0][i - 1];
		}
		for (int i = 1; i < T.length; i++) {
			T[i][0] = cost[i][0] + T[i - 1][0];
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				T[i][j] = cost[i][j] + Math.min(T[i][j - 1], T[i - 1][j]);
			}
		}
		for (int i = 0; i < T.length; i++) {
			System.out.println();
			for (int j = 0; j < T[0].length; j++) {
				System.out.print(T[i][j] + " ");
			}
		}
		return T[cost.length - 1][cost[0].length - 1];
	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		MinimumCostPathMatrix mcpm = new MinimumCostPathMatrix();
		System.out.println(mcpm.minCost(cost));
	}

}
