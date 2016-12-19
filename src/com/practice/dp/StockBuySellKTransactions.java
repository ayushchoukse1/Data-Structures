package com.practice.dp;

public class StockBuySellKTransactions {

	public int maxProfit(int[] prices, int k) {
		int[][] T = new int[k +1][prices.length];
		for (int i = 0; i < T.length; i++) {
			T[i][0] = 0;
		}
		for (int j = 0; j < T[0].length; j++) {
			T[0][j] = 0;
		}
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				int max = 0;
				for (int m = 0; m <= j - 1; m++) {
					int sum = prices[j] - prices[m] + T[i - 1][m];
					max = sum > max ? sum : max;
				}
				T[i][j] = Math.max(T[i][j-1], max);
			}
		}
		return T[k][prices.length - 1];
	}

	public static void main(String[] args) {
		StockBuySellKTransactions sbt = new StockBuySellKTransactions();
		int prices[] = { 2, 5, 7, 1, 4, 3, 1, 3 };
		System.out.println(sbt.maxProfit(prices, 3));
	}

}
