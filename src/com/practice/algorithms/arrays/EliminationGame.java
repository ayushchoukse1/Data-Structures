package com.practice.algorithms.arrays;

import java.util.Stack;

public class EliminationGame {
	public int lastRemaining(int n) {
		if (n == 1) {
			return 1;
		} else {
			if (n % 2 == 0) {
				return n - 2 * lastRemaining(n / 2) + 2;
			} else {
				return lastRemaining(n - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EliminationGame eg = new EliminationGame();
		System.out.println(eg.lastRemaining(100000000));
	}

}
