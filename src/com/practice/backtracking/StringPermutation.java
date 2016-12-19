package com.practice.backtracking;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringPermutation {
	public void permute(String str) {
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
		computePermutationUtil(chrs, count, result, 0);

	}

	private void computePermutationUtil(char[] chrs, int[] count, char[] result, int level) {
		if (level == result.length) {
			printArray(result);
			return;
		}
		for (int i = 0; i < chrs.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = chrs[i];
			count[i]--;
			computePermutationUtil(chrs, count, result, level + 1);
			count[i]++;
		}
	}


	private void printArray(char[] result) {
		for (char c : result) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		sp.permute("aabc");
	}

}
