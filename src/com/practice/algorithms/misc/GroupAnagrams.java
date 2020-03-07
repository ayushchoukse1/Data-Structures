package com.practice.algorithms.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			if (map.containsKey(getAsciiSum(strs[i])))
				map.get(getAsciiSum(strs[i])).add(strs[i]);
			else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(getAsciiSum(strs[i]), list);
			}
		}
		Iterator<Entry<Integer, List<String>>> it = map.entrySet().iterator();
		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> value : map.values()) {
			result.add(value);
		}
		return result;
	}

	public int getAsciiSum(String s) {
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < c.length; i++)
			sum += c[i];
		return sum;
	}

	public static void main(String[] args) {

		GroupAnagrams ga = new GroupAnagrams();

	}

}
