package com.practice.arrays;

public class LeaderInArray {

	/*
	 * Write a program to print all the LEADERS in the array. An element is
	 * leader if it is greater than all the elements to its right side. And the
	 * rightmost element is always a leader. For example int the array {16, 17,
	 * 4, 3, 5, 2}, leaders are 17, 5 and 2
	 */

	// TIME COMPLEXITY: O(n)
	// This method scans the array right setting the rightmost element as max
	// and when max changes print the leader to console.
	public void printLeaders(int a[]) {
		// set the right most element as max.
		int right = a.length - 1;
		int max = a[right];

		// right most integer will always be the leader.
		System.out.print(max + ", ");

		// Scan for every max element than the current one.
		for (int i = right; i >= 0; i--) {
			if (max < a[i]) {
				max = a[i];
				System.out.print(a[i] + ", ");
			}
		}
	}

	public static void main(String[] args) {
		// sample array
		int a[] = { 16, 17, 4, 3, 5, 2 };
		LeaderInArray object = new LeaderInArray();
		object.printLeaders(a);
	}
}
