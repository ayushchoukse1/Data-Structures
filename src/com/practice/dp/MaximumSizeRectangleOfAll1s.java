package com.practice.dp;

import com.practice.leetcode.LargestRectangleInHistogram;

public class MaximumSizeRectangleOfAll1s {

	public int maximumRectangle(int[][] T) {
		LargestRectangleInHistogram hs = new LargestRectangleInHistogram();
		int maxArea = 0;
		int[] arr = new int[T[0].length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[0].length; j++) {
				if (T[i][j] == 0)
					arr[j] = 0;
				else
					arr[j]++;
			}
			int area = hs.largestRectangleArea(arr);
			maxArea = area > maxArea? area : maxArea;
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int input[][] = { { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 1 },
				{ 1, 1, 1, 1 } };
		MaximumSizeRectangleOfAll1s msr = new MaximumSizeRectangleOfAll1s();
		System.out.println(msr.maximumRectangle(input));
	}

}
