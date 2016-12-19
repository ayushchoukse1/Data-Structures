package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class NumberPermutationII {
	/*	
		Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
				For example,
				[1,1,2] have the following unique permutations:
				[
				  [1,1,2],
				  [1,2,1],
				  [2,1,1]
				]
		*/
	public List<List<Integer>> permuteUnique(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (Integer c : nums) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else
				map.put(c, map.get(c) + 1);
		}
		int[] chrs = new int[map.size()];
		int[] count = new int[map.size()];
		int i = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			chrs[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		int[] result = new int[nums.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		return computePermutationUtil(chrs, count, result, 0, list);

	}

	private List<List<Integer>> computePermutationUtil(int[] chrs, int[] count, int[] result, int level,
			List<List<Integer>> list) {

		if (level == result.length) {
			list.add(getList(result));
		}
		for (int i = 0; i < chrs.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = chrs[i];
			count[i]--;
			computePermutationUtil(chrs, count, result, level + 1, list);
			count[i]++;
		}
		return list;
	}

	private List<Integer> getList(int[] result) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			temp.add(result[i]);
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		NumberPermutationII np2 = new NumberPermutationII();
		System.out.println(np2.permuteUnique(nums));
	}

}
