package com.practice.algorithms.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Subsets2018 {

	public List<List<Integer>> printSubsets(int[] nums) {
		// store nums in an input array with their counts in a different array.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}
		int[] input = new int[map.size()];
		int[] count = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			input[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		int[] output = new int[nums.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		return combination(input, count, 0, output, 0, list);

	}

	public List<List<Integer>> combination(int[] input, int[] count, int pos, int[] output, int len,
			List<List<Integer>> list) {
		
		list.add(print(output, len));
		for (int i = pos; i < input.length; i++) {
			if (count[i] == 0)
				continue;
			output[len] = input[i];
			count[i]--;
			combination(input, count, i, output, len + 1, list);
			count[i]++;
		}
		return list;
	}

	public List<Integer> print(int[] output, int len) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			list.add(output[i]);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Subsets2018 ss = new Subsets2018();
		ss.printSubsets(nums);
	}
}
