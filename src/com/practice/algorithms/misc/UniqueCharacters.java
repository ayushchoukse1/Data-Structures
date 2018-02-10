package com.practice.algorithms.misc;

import java.util.HashMap;

public class UniqueCharacters {
	// Implement an algorithm to determine if a string has all unique characters.

	public static boolean checkUnique(String s) {
		if (s == null || s.length() == 0)
			return true;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else if (map.containsKey(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(UniqueCharacters.checkUnique("qwertyuiop[asdfghkjl;'zxcvbnm,./><"));
		System.out.println(UniqueCharacters.checkUnique("a"));
		System.out.println(UniqueCharacters.checkUnique(""));
		System.out.println(UniqueCharacters.checkUnique("aa"));
		System.out.println(UniqueCharacters.checkUnique(null));
	}
}
