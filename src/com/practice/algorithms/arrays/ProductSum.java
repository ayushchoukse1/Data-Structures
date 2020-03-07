package com.practice.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

	public int getSum(List<Object> a) {
		int sum = 0;
		return sum;
	}

	public static void main(String[] args) {
		// [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
		List<Object> ls = new ArrayList<Object>();
		ProductSum ps = new ProductSum();
		ls.add(2);
		ls.add(10);
		List<Object> list1 = new ArrayList<Object>();
		list1.add(7);
		list1.add(-1);
		List<Object> list2 = new ArrayList<Object>();
		List<Object> list3 = new ArrayList<Object>();
		List<Object> list4 = new ArrayList<Object>();
		list4.add(3);
		list2.add(list3.add(list4));
		ls.add(5);
		
	}

}
