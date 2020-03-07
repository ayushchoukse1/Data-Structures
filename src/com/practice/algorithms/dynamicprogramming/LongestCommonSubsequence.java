package com.practice.algorithms.dynamicprogramming;

public class LongestCommonSubsequence {

	public int lcs(String s1, String s2) {
		int[][] T = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 0; i < T.length; i++) {
			T[i][0] = 0;
		}
		for (int i = 0; i < T[0].length; i++) {
			T[0][i] = 0;
		}
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					T[i][j] = 1 + T[i - 1][j - 1];
					System.out.print(s2.charAt(j - 1));
				} else {
					T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
				}
				if (T[i][j] > max) {
					max = T[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "acbcf";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.lcs(s1, s2));
	}

}
