package com.practice.algorithms.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DivideArrayinSetsofKConsecutiveNumbers {
	public boolean result;

	public boolean isPossibleDivide(int[] nums, int k) {
		int l = nums.length;
		int listCount = 0;
		if (l < k)
			return false;
		while (l >= k) {
			l = l - k;
			listCount++;
			if (l == 0)
				break;
		}
		Arrays.sort(nums);
		LinkedList<Integer>[] lists = new LinkedList[listCount];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList();
		}
		for (int i = 0; i < nums.length; i++) {
			insert(lists, nums[i], k, listCount);
		}
		int totalListCount = 0;
		for (int i = 0; i < listCount; i++) {
			totalListCount = totalListCount + lists[i].size();
		}
		if (totalListCount == nums.length)
			return true;
		else
			return false;
	}

	public void insert(LinkedList<Integer>[] lists, int i, int k, int listCount) {
		int count = 0;
		while (count < listCount) {
			if (lists[count].size() < k) { // add only if list size is less than k
				if (lists[count].isEmpty()) {
					lists[count].addLast(i);
					break;
				} else if (lists[count].getLast() == i - 1) {
					lists[count].addLast(i);
					break;
				}
			}
			count++;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };

		DivideArrayinSetsofKConsecutiveNumbers obj = new DivideArrayinSetsofKConsecutiveNumbers();

		System.out.println(obj.isPossibleDivide(nums, 3));
	}

}
