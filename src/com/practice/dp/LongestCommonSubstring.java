package com.practice.dp;

public class LongestCommonSubstring {

	public int lcs(String str1, String str2) {
		int[][] T = new int[str1.length() + 1][str2.length() + 1];
		int max = 0;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1] + 1;
					if (max < T[i][j]) {
						max = T[i][j];
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.lcs("abcdaf","454"));
	}

}
