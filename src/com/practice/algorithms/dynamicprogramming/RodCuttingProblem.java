package com.practice.algorithms.dynamicprogramming;

class Rod {
	int length;
	int value;

	public Rod(int length, int value) {
		super();
		this.length = length;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Rod [length=" + length + ", value=" + value + "]";
	}

}

public class RodCuttingProblem {
	public int maximizeProfit(Rod[] rods, int total) {
		int[][] T = new int[rods.length][total + 1];
		for (int i = 0; i < T.length; i++)
			T[i][0] = 0;
		for (int j = 1; j < T[0].length; j++) {
			T[0][j] = j * rods[0].value;
		}

		int c = 0;
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j < rods[i].length) {
					T[i][j] = T[i - 1][j];

				} else {
					T[i][j] = Math.max(T[i - 1][j], T[i][j - rods[i].length] + rods[i].value);
					if (c < T[i][j]) {
						c = T[i][j];
					}
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Rod[] rods = new Rod[4];
		rods[0] = new Rod(1, 2);
		rods[1] = new Rod(2, 5);
		rods[2] = new Rod(3, 7);
		rods[3] = new Rod(4, 8);

		RodCuttingProblem rcp = new RodCuttingProblem();
		System.out.println(rcp.maximizeProfit(rods, 5));
	}

}
