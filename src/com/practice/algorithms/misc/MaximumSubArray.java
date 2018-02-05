package com.practice.algorithms.misc;

import java.util.Stack;

public class MaximumSubArray {

	/*	
		Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	
		For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
		the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	*/
	public int findMaxSubArray(int[] arr) {
		int maxSoFar = arr[0], maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding = Math.max((maxEnding + arr[i]), arr[i]);
			maxSoFar = Math.max(maxEnding, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		MaximumSubArray o = new MaximumSubArray();
		System.out.println(o.findMaxSubArray(arr));
	}
}
