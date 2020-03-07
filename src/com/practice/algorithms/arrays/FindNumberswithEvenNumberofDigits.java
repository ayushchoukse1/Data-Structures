package com.practice.algorithms.arrays;

public class FindNumberswithEvenNumberofDigits {
	public int findNumbers(int[] nums) {
		int small = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = getDigitCount(nums[i]);
			if (nums[i] % 2 == 0) {
				small++;
			}
		}
		return small;
	}

	public int getDigitCount(int a) {
		int count = 0;
		while (a != 0) {
			a /= 10;
			++count;
		}
		System.out.println("count = " + count);
		return count;
	}

	public static void main(String[] args) {
		// [12,345,2,6,7896,100000]
		FindNumberswithEvenNumberofDigits obj = new FindNumberswithEvenNumberofDigits();
		int[] nums = { 0, 12, 345, 2, 6, 7896, 100000 };
		System.out.println(obj.findNumbers(nums));
	}

}
