package com.practice.algorithms.dynamicprogramming;

public class PalindromicPartition {

	public int minPartition(String str) {
		int[][] T = new int[str.length()][str.length()];
		for (int i = 0; i < T.length; i++)
			T[i][i] = 0;
		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (isPalindrome(str.substring(i, j+1))) {
					System.out.println(str.substring(i, j + 1) + " = " + isPalindrome(str.substring(i, j + 1)));
					T[i][j] = 0;
				} else {
					for (int k = i + 1; k <= j; k++) {
						T[i][j] =  1 + Math.min(T[i][k-1] + T[k][j], T[i][j]);
					}
				}
			}
		}
		for (int i = 0; i < T.length; i++) {
			System.out.println();
			for (int j = 0; j < T[0].length; j++) {
				System.out.print(T[i][j] + " ");
			}
		}
		return T[0][str.length() - 1];
	}
	public  int partition(String s) {
		  int n = s.length();
		  boolean palindrome[][] = new boolean[n][n]; //boolean table
		  
		  //Trivial case: single letter palindromes
		  for (int i = 0; i < n; i++) {
			  palindrome[i][i] = true;
		  }
		  
		  //Finding palindromes of two characters.
		  for (int i = 0; i < n-1; i++) {
		    if (s.charAt(i) == s.charAt(i+1)) {
		      palindrome[i][i+1] = true;
		    }
		  }
		  
		  //Finding palindromes of length 3 to n
		  for (int curr_len = 3; curr_len <= n; curr_len++) {
		    for (int i = 0; i < n-curr_len+1; i++) {
		      int j = i+curr_len-1;
		      if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
		    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
		      {
		    	palindrome[i][j] = true; 
		      }
		    }
		  }
		  
		  int[] cuts = new int[n];
		  for(int i=0; i<n; i++)
		  {
			  int temp = Integer.MAX_VALUE;
			  if(palindrome[0][i])
				  cuts[i] = 0;
			  else
			  {
				  for(int j=0; j<i; j++)
				  {
					 if((palindrome[j+1][i]) && temp > cuts[j] + 1) 
					 {
						 temp = cuts[j] + 1;
					 }
				  }
				  cuts[i] = temp;
			  }			  
		  }
		  return cuts[n-1];
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
		PalindromicPartition pp = new PalindromicPartition();
		System.out.println(pp.minPartition("banana"));
		System.out.println(pp.partition("banana"));
	}

}
