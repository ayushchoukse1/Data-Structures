package com.practice.dp;

public class CoinChangingProblem {
	public int cost(int[] coins, int total) {
		int[][] T = new int[coins.length + 1][total + 1];
		for (int i = 0; i < T.length; i++)
			T[i][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					T[i][j] = T[i - 1][j];

				} else {
					T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];
				}
			}
		}
		return T[coins.length][total];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };

		CoinChangingProblem cp = new CoinChangingProblem();
		System.out.println(cp.cost(coins, 5));
	}

}
