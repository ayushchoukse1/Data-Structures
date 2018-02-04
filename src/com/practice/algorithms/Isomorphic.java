package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
public static void main(String[] args) {
	System.out.println(isIsomorphic("egg", "adt"));
}
public static boolean isIsomorphic(String s, String t) {
if (s.length() != t.length()) return false;
Map<Character, Integer> map1 = new HashMap<>();
Map<Character, Integer> map2 = new HashMap<>();
for (Integer i = 0; i < s.length(); i++)
{
	//System.out.println((map1.put(s.charAt(i), i))+" = "+map2.put(t.charAt(i), i));
if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) return false;
}
return true;
}
}
