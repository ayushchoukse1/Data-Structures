package com.practice.algorithms.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SymmetrySets {

	public static void main(String[] args) {
		int a[][] = { { 1, 2 }, { 3, 4 }, { 5, 9 }, { 4, 2 }, { 9, 5 } };
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
		}
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i][1])) {
				System.out.println("true");
				System.out.println(map.get(a[i][1]));
			} else {
				map.put(a[i][0], a[i][1]);
			}
		}
	}

}
