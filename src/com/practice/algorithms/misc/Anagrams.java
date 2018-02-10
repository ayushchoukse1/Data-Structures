package com.practice.algorithms.misc;

public class Anagrams {
	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length())
			return false;
		String combined = s1 + s2;
		int i = 0;
		int j = combined.length() - 1;
		while (i <= j) {
			if (combined.charAt(i) == combined.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Anagrams.isAnagram("", ""));
		System.out.println(Anagrams.isAnagram("aa", ""));
		System.out.println(Anagrams.isAnagram("", "aa"));
		System.out.println(Anagrams.isAnagram(null, "aa"));
		System.out.println(Anagrams.isAnagram("aa", null));
		System.out.println(Anagrams.isAnagram(null, null));
		System.out.println(Anagrams.isAnagram("ayush", "hsuya"));
		System.out.println(Anagrams.isAnagram("1234", "4321"));
		System.out.println(Anagrams.isAnagram("ayush1234", "4321hsuya"));
		System.out.println(Anagrams.isAnagram("ayush", "choukse"));
		System.out.println(Anagrams.isAnagram("aulenaoeunga", "aulenaoeaeea"));	
		//System.out.println(Anagrams.isAnagram("ayush1234", "4321hsuya"));
		System.out.println(Anagrams.isAnagram("ayush12341", "4321hsuya"));

		

	}

}
