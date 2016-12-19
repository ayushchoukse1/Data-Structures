package com.practice.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountDuplicates {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,2,2,3,3,4,5,4,5,6};
		System.out.println(countDuplicates(numbers));
	}

	static int countDuplicates(int[] numbers) {
		if (numbers == null) {
			throw new NullPointerException();
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (int i : numbers) {
			if (map.containsKey(i)) {
				//map already has the key. update the map entry.
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		int count =0;
		for(Entry<Integer, Integer> entry : map.entrySet()){
			if (entry.getValue() > 1) {
				count++;
			}
		}
		
		return count;
	}
}
