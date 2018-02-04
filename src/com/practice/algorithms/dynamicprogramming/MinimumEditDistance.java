package com.practice.algorithms.dynamicprogramming;

public class MinimumEditDistance {

	public int editDistance(String str1, String str2) {
		int count = 0;
		int[][] T = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < str1.length() + 1; i++) {
			T[i][0] = i;
		}
		for (int j = 0; j < str2.length() + 1; j++) {
			T[0][j] = j;
		}
		
		for (int i = 1; i <= str1.length() ; i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					T[i][j] = T[i-1][j-1];
				}else{
					T[i][j] = min(T[i][j-1],T[i-1][j-1],T[i-1][j]) + 1;
				}
			}
		}
		
//		for (int i = 0; i < T.length; i++) {
//			System.out.println();
//			for (int j = 0; j < T[0].length; j++) {
//				System.out.print(T[i][j]+" ");
//			}
//		}
		return T[str1.length()][str2.length()];
	}

	private int min(int i, int j, int k) {
		int min =i; 
		
		if (j < min) {
			min = j;
		}
		if (k < min) {
			min=k;
		}
		return min;
	}

	public static void main(String[] args) {
		MinimumEditDistance med = new MinimumEditDistance();
		System.out.println(med.editDistance( "azced","abcdef"));
	}
}
