package com.practice.algorithms.misc;

import java.util.HashMap;

public class BracketsUsingHashMap {

	public boolean balanced(String s) {
		boolean flag = false;
		if (s.isEmpty())
			return flag;
		if (s.length() == 1)
			return flag;
		char[] arr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : arr) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		if (map.get('{') == map.get('}') && map.get('(') == map.get(')') && map.get('[') == map.get(']')) {
			flag = true;
		}
		/*	for (Entry<Character, Integer> entry : map.entrySet())
				System.out.println(entry.getKey() + " : " + entry.getValue());*/
		return flag;
	}

	public static void main(String[] args) {
		String s = "{(){[{()](}[)}]()()()()()}";
		String s1 = "[]";
		BracketsUsingHashMap o = new BracketsUsingHashMap();
		System.out.println(o.balanced(s));
	}

}
