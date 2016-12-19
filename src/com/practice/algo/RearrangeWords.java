package com.practice.algo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class RearrangeWords {
	public static void main(String[] args) {
		// rearrangeWord("xy");
		System.out.println(rearrangeString("ayush"));
	}

	public static String rearrangeWord(String word) {
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);
		for (int i = wordArray.length - 1; i >= 0; i--) {
			System.out.println(wordArray[i]);
		}
		return null;
	}

	// public static void main(String[] args) {
	//
	// System.out.println(rearrangeString("ayush"));
	//
	// }

	static String rearrangeString(String s) {

		StringBuffer sb = new StringBuffer(s);
		int i = sb.length() - 1;
		while (i > 0 && sb.charAt(i - 1) >= sb.charAt(i)) {
			i--;
		}
		if (i <= 0) {
			return "no answer";
		}
		int j = sb.length() - 1;
		while (sb.charAt(j) <= sb.charAt(i - 1)) {
			j--;
		}
		char ch = sb.charAt(i - 1);
		sb.setCharAt(i - 1, sb.charAt(j));
		sb.setCharAt(j, ch);

		j = sb.length() - 1;

		while (i < j) {

			ch = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, ch);
			i++;
			j--;

		}

		return String.valueOf(sb);
	}

}
