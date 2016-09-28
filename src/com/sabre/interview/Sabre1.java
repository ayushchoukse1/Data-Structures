//package com.sabre.interview;
//
//import java.util.HashSet;
//import java.util.Iterator;
//
//public class Sabre1 {
//
//	public static void main(String args[]) {
//		// convert int to binary
//		String num = Integer.toBinaryString(n);
//		// get ones complement
//		char[] stringArray = num.toCharArray();
//		String onesComp = null;
//		for (int i = stringArray.length - 1; i >= 0; i--) {
//			if (stringArray[i] == '0') {
//				stringArray[i] = '1';
//			} else
//				stringArray[i] = '0';
//		}
//	
//
//		// convert string array to int
//		String complNum = new String(stringArray);
//		//return Integer.parseInt(complNum, 2);
//		
//		
//		int pairCount = 0;
//
//		if (a.length > 1 && k >= 1) {
//
//			HashSet<Integer> set = new HashSet<Integer>();
//			// Remove the duplicates by adding the items in the set
//			for (int i = 0; i < a.length; i++) {
//				int element = a[i];
//				if (!set.contains(element)) {
//					set.add(element);
//				}
//			}
//
//			// Traversing the elements in the set
//			Iterator<Integer> setElements = set.iterator();
//
//			while (setElements.hasNext()) {
//
//				Integer element = setElements.next();
//				Integer value = element + k;
//				if (set.contains(value)) {
//					pairCount++;
//				}
//			}
//		} else {
//			pairCount = 0;
//		}
//		return pairCount;
//	}
//}