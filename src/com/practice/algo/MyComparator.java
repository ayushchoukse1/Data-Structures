package com.practice.algo;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int result = 0;
		if (o1 > o2) {
			result = 1;
		} else if (o1 > o2) {
			result = -1;
		}
		return result;
	}
}
