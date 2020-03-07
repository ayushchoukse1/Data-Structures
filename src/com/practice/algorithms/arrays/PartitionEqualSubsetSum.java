package com.practice.algorithms.arrays;

import java.util.HashMap;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int total = 0;
		for (int i : nums) {
			total += i;
		}
		if ((total % 2) != 0)
			return false;
		return isPossible(nums, 0, 0, total, new HashMap<String, Boolean>());
	}

	public boolean isPossible(int[] nums, int i, int sum, int total, HashMap<String, Boolean> map) {
		// base condition
		String current = i + "" + sum;
		if (map.containsKey(current))
			return map.get(current);
		if (sum * 2 == total)
			return true;
		if (sum > total / 2 || i >= nums.length)
			return false;

		Boolean result = isPossible(nums, i + 1, sum, total, map) || isPossible(nums, i + 1, sum + nums[i], total, map);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		System.out.println(obj.canPartition(nums));
	}

}
