package com.practice.dp;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		boolean[][] T = new boolean[s.length()][s.length()];
		String finalString = "";
		int max = 1;

		for (int i = 0; i < s.length(); i++) {
			T[i][i] = true;
		}
		for (int i = 1; i < T.length; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				T[i - 1][i] = true;
			}

		}

		for (int l = 2; l < s.length(); l++) {
			for (int i = 0; i < s.length() - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && T[i + 1][j - 1]) {
					T[i][j] = true;
					if (max < j - i) {
						max = j - i;
						finalString = s.substring(i, j+1);
					}
				}
			}
		}
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T.length; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		return finalString;
	}

	private boolean isPalindrome(String substring) {
		if (substring.length() == 1) {
			return true;
		}
		int i = 0, j = substring.length() - 1;
		while (i < j) {
			if (substring.charAt(i) != substring.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("babad"));
	}

}
