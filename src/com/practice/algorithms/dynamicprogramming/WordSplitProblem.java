package com.practice.algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordSplitProblem {

	public String wordSplit(String word, Set<String> dict) {
		// if (word == null || dict.isEmpty()) {
		// return null;
		// }
		int[][] T = new int[word.length()][word.length()];
		for (int i = 0; i < T.length; i++)
			for (int j = 0; j < T[i].length; j++)
				T[i][j] = -1; // -1 indicates that words between i and j cannot
								// be split.
		for (int l = 1; l <= word.length(); l++) {
			for (int i = 0; i < word.length() - l + 1; i++) {
				int j = i + l - 1;
				String str = word.substring(i, j + 1);
				if (dict.contains(str)) {
					T[i][j] = i;
					continue;
				}
				for (int k = i + 1; k <= j; k++) {
					if (T[i][k - 1] != -1 && T[k][j] != -1) {
						T[i][j] = k;
						break;
					}
				}
			}
		}
		if (T[0][word.length() - 1] == -1) {
			return null;
		}

		StringBuffer buffer = new StringBuffer();
		int i = 0, j = word.length() - 1;
		while (i < j) {
			int k = T[i][j];
			if (i == k) {
				buffer.append(word.substring(i, j + 1));
				break;
			}
			buffer.append(word.substring(i, k) + " ");
			i = k;
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("had");
		dictionary.add("play");
		dictionary.add("to");
		String str = "Ihadliketoplay";
		WordSplitProblem wps = new WordSplitProblem();
		System.out.println(wps.wordSplit(str, dictionary));
		// System.out.println(wps.breakWordDP(str, dictionary));
	}

}
