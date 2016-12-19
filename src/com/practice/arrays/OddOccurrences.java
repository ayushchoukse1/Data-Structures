package com.practice.arrays;

public class OddOccurrences {

	// Find the Number Occurring Odd Number of Times

	public int getOddOccurrence(int a[]) {
		// XOR all the integers in the array.
		// if the numbers are even occurring the result will be zero
		// else the remaining number is the odd occurring integer in the array.
		int result = 0;
		for (int i = 0; i < a.length-1; i+=2) {
			result=result^a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// integer array with 2 occurring odd times
		int a[] = { 1, 1, 2, 2, 2, 3, 3, 4, 4 };
		
		OddOccurrences object=new OddOccurrences();
		System.out.println(object.getOddOccurrence(a));
	}
}