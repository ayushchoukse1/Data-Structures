package com.practice.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Subsets {

	/*	
		Given a set of distinct integers, nums, return all possible subsets.
	
				Note: The solution set must not contain duplicate subsets.
	
				For example,
				If nums = [1,2,3], a solution is:
	
				[
				  [3],
				  [1],
				  [2],
				  [1,2,3],
				  [1,3],
				  [2,3],
				  [1,2],
				  []
				]
		*/

	public List<List<Integer>> subsets(int[] nums) {
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
		int result[] = new int[nums.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		return combinationUtil(chrs, count, 0, result, 0, list);
	}

	private List<List<Integer>> combinationUtil(int[] chrs, int[] count, int pos, int[] result, int len,
			List<List<Integer>> list) {
		list.add(printOutput(result, len));
		for (int i = pos; i < chrs.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[len] = chrs[i];
			count[i]--;
			combinationUtil(chrs, count, i, result, len + 1, list);
			count[i]++;
		}
		return list;
	}

	private List<Integer> printOutput(int[] result, int len) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) { 
			temp.add(result[i]);
		}
		return temp;
	}

	public static void main(String[] args) {
	
		int[] nums = { 1,2,3};
		Subsets ss = new Subsets();
		System.out.println(ss.subsets(nums));
	}

}
