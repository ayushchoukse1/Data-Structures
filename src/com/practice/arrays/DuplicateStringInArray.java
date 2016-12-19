package com.practice.arrays;

import java.util.HashMap;
import java.util.HashSet;


public class DuplicateStringInArray {
	
	public void findDuplicateString(String[] array){
		HashSet<String> s1 = new HashSet<String>();
		HashSet<String> s2 = new HashSet<String>();
		for (String string : array) {
			if(!s1.add(string)){
				s1.remove(string);
				System.out.println(string);
			}
		}
//		Iterator<String> it = s2.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
	}
	public static void main(String[] args) {
		String[] array = {"abc","abcd","ab","abc","ab","abghr"};
		DuplicateStringInArray o = new DuplicateStringInArray();
		o.findDuplicateString(array);
	}

}
