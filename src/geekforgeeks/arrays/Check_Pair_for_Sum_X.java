package geekforgeeks.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Check_Pair_for_Sum_X {

	public boolean result(int A[], int l, int r, int x) {
		// start from left and right of the integer array.
		while (l < r) {
			// if the sum of integer is equal to the given sum return true.
			if (A[l] + A[r] == x) {
				return true;
			} else
			// if the sum of two arrays is smaller than the asked sum
			// then increment the left pointer
			if (A[l] + A[r] < x) {
				l++;
			} else {
				// if the sum of two arrays is greater than the asked sum
				// then increment the left pointer
				r--;
			}
		}
		// if not found return false.
		return false;
	}

	public static void main(String[] args) {
		// given integer array A[] and a number X.
		int[] A = { 1, 2, 3, 4, 5 };
		int Sum = 3;
		int length = 5;
		// Take two pointers to compare.
		int left = 0;
		int right = length - 1;

		Check_Pair_for_Sum_X object = new Check_Pair_for_Sum_X();
		System.out.print(object.result(A, left, right, Sum));
	}

}