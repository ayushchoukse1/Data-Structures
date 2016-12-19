package com.practice.backtracking;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class StringCombination {
	public void combination(String str) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for (Character c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else
				map.put(c, map.get(c) + 1);
		}
		char[] chrs = new char[map.size()];
		int[] count = new int[map.size()];
		int i = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			chrs[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		char result[] = new char[str.length()];
		combinationUtil(chrs, count, 0, result, 0);

	}

	private void combinationUtil(char[] chrs, int[] count, int pos, char[] result, int len) {
		printOutput(result, len);
		for (int i = pos; i < chrs.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[len] = chrs[i];
			count[i]--;
			combinationUtil(chrs, count, i, result, len + 1);
			count[i]++;
		}
	}

	private void printOutput(char[] result, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StringCombination sp = new StringCombination();
		sp.combination("aabc");

	}

}
