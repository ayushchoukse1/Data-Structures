package com.practice.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	/*	Given n non-negative integers representing the histogram's bar 
	 * height where the width of each bar is 1, find the area of largest 
	 * rectangle in the histogram.
	 * For example, 
	 * Given heights = [2,1,5,6,2,3], 
	 * return 10.
	 */

	public int largestRectangleArea(int[] heights) {
		int maxArea = -1;
		int area = 0;
		int i = 0;
		Stack<Integer> s = new Stack<Integer>();
		// Loop for every member in the array
		while (i < heights.length) {
			// insert into stack if the stack is empty or
			// the next element in the array is greater than element whose index
			// is at the top of the stack.
			if (s.isEmpty() || heights[s.peek()] <= heights[i]) {
				// push into stack
				s.push(i++);
			} else {
				// if the next element in the array is smaller than the element
				// whose index is at the top of the stack. Then calculate the
				// area of the rectangle by popping the top element in the stack
				int top = s.pop();
				if (s.isEmpty()) {
					area = heights[top] * i;
				} else {
					area = heights[top] * (i - s.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			if (s.isEmpty()) {
				area = heights[top] * i;
			} else {
				area = heights[top] * (i - s.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(obj.largestRectangleArea(arr));
	}

}
