package com.practice.dp;

public class LongestPalindromicSubsequence {

	public int lps(String str) {
		int[][] T = new int[str.length()][str.length()];
		for (int i = 0; i < T.length; i++)
			for (int j = 0; j < T[0].length; j++)
				if (i == j)
					T[i][j] = 1;

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && str.charAt(i) == str.charAt(j)) {
					T[i][j] = 2;
				} else if (str.charAt(i) == str.charAt(j)) {
					T[i][j] = 2 + T[i + 1][j - 1];
				} else {
					T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]);
				}

			}
		}
		return T[0][str.length() - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.lps("agbdba"));
	}

}
