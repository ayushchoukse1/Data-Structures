package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/*
	 * 
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] +
	 * nums[1] = 2 + 7 = 9, return [0, 1]
	 * 
	 */
	
	public int[] findTwoSum(int[] nums, int target){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();	
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int diff= target-nums[i];
			if (map.containsKey(diff) && map.get(diff) != i) {
				return new int[] {i, map.get(diff)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
		
	}
	public static void main(String args[] ){
		
	TwoSum obj = new TwoSum();
	int[] sums = new int[4];
	sums[0] = 2;
	sums[1] = 7;
	sums[2] = 11;
	sums[3] = 15;
	int[] res = obj.findTwoSum(sums, 18);
	System.out.println(sums[res[0]]+" "+sums[res[1]]);
	}
}
