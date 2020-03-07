package com.practice.algorithms.arrays;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int asciiS = 0;
		int asciiT = 0;
		for (char i : s.toCharArray())
			asciiS += i;
		for (char i : t.toCharArray())
			asciiT += i;
		System.out.println((char) (Math.abs(asciiS - asciiT)));
		return 's';
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTheDifference fd = new FindTheDifference();
		fd.findTheDifference("abcd", "abcde");
	}

}
