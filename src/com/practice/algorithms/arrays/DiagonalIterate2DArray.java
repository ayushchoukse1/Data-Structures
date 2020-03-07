package com.practice.algorithms.arrays;

import java.util.Stack;

public class DiagonalIterate2DArray {
	public static int[][] a = new int[5][5];

	public static void printDiagonalArray(int[][] a) {
		for (int i = 0; i < a[0].length; i++) {
			int l = 0;
			int m = i;
			while (m >= 0 && l <= i) {
				System.out.print(a[l][m] + " ");
				l++;
				m--;
			}
			System.out.println();
		}
		Stack<Integer> s1 = new Stack<Integer>();
		s1.removeAllElements();
		for (int i = 1; i < a.length; i++) {
			int l = i;
			int m = a.length - 1;
			while (l <= a.length - 1 && m > 0) {
				System.out.print(a[l][m] + " ");
				// System.out.print("( "+a[l][m] + " " + "l = " + l + " m= " + m+" )");
				l++;
				m--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = count;
				count++;
			}
		}
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n \n \n \n ");
		DiagonalIterate2DArray.printDiagonalArray(a);
	}

}
