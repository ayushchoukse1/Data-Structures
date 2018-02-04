package com.practice.algorithms.leetcode;

public class CoinChangeProblem {
	/*
	You are given coins of different denominations and a total amount of money amount. 
	Write a function to compute the fewest number of coins that you need to make up that amount. 
	If that amount of money cannot be made up by any combination of the coins, return -1.
	
	Example 1:
	coins = [1, 2, 5], amount = 11
	return 3 (11 = 5 + 5 + 1)
	
	Example 2:
	coins = [2], amount = 3
	return -1.
	
	Note:
	You may assume that you have an infinite number of each kind of coin.
	*/

	public int coinChange(int[] coins, int amount) {
		int T[] = new int[amount + 1];
		int R[] = new int[amount + 1];
		T[0] = 0;
		for (int i = 1; i <= amount; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coins[j]) {
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = T[i - coins[j]] + 1;
						R[i] = j;
					}
				}
			}
		}
		// print the denominations.
		//printCombinations(R, coins);
		if (T[amount] >= Integer.MAX_VALUE -1) {
			return -1;
		}
		return T[amount];
	}

	private void printCombinations(int[] R, int[] coins) {
		if (R[R.length - 1] == -1) {
			System.out.println("No Denominations possible to make the amount.");
			return;
		}
		int start = R.length - 1;
		while (start != 0) {
			int j = R[start];
			System.out.println(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.println();

	}

	public static void main(String[] args) {
		CoinChangeProblem obj = new CoinChangeProblem();
		int[] arr = { 5, 2, 5 };
		System.out.println(obj.coinChange(arr, 3));
	}
}
