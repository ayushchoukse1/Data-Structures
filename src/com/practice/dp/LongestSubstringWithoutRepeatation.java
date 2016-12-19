package com.practice.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatation {

	/*
	 * Given a string, find the length of the longest substring without repeating characters.
	
	Examples:
	
	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. 
	
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	*/
	public int longestSubstring(String str) {
		int max = 0;
		int[] T = new int[str.length()];
		System.out.println(T.length);
		Set<Character> set = new HashSet<Character>();
		set.add(str.charAt(0));
		T[0] = 1;
		for (int i = 1; i < T.length ; i++) {
			if (set.add(str.charAt(i))) {
				T[i] = 1 + T[i - 1];
			} else {
				System.out.println(set);
				set.clear();
				set.add(str.charAt(i));
				T[i] = 1;
			}
		}
		for (int i = 0; i < T.length; i++) {
			System.out.print(T[i]+" ");
			if (max < T[i]) {
				max = T[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatation lswr = new LongestSubstringWithoutRepeatation();
		System.out.println(lswr.longestSubstring("dvdf"));
	}

}
