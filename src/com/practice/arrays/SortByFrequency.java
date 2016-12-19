package com.practice.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortByFrequency {

	/*
	 * Print the elements of an array in the decreasing frequency if 2 numbers
	 * have same frequency then print the one which came 1st E.g. 2 5 2 8 5 6 8
	 * 8 output: 8 8 8 2 2 5 5 6.
	 */
	public class ValueComparator<T1, T2 extends Comparable<T2>> implements Comparator<T1> {
		Map<T1, T2> base;

		public ValueComparator(Map<T1, T2> base) {
			this.base = base;
		}

		@Override
		public int compare(T1 k1, T1 k2) {
			T2 val1 = base.get(k1);
			T2 val2 = base.get(k2);
			return val1.compareTo(val2);
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 5, 2, 8, 5, 6, 8, 8 };
		SortByFrequency sortByFrequency = new SortByFrequency();
		sortByFrequency.sort(array);
	}

	public void sort(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		ValueComparator<Integer, Integer> bvc = new ValueComparator<Integer, Integer>(map);
		TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(bvc);
		sortedMap.putAll(map);

		ArrayList<Integer> output = new ArrayList<Integer>();
		for (Integer i : sortedMap.keySet()) {
			for (int c = 0; c < sortedMap.get(i); c++) {
				output.add(i);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " = " + entry.getValue());
		System.out.println(output);
	}
}
