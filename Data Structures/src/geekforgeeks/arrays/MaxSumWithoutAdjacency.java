package geekforgeeks.arrays;

public class MaxSumWithoutAdjacency {

	/*
	 * Given an array of positive numbers, find the maximum sum of a subsequence
	 * with the constraint that no 2 numbers in the sequence should be adjacent
	 * in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10
	 * 7 should return 15 (sum of 3, 5 and 7).Answer the question in most
	 * efficient way.
	 */

	// This function returns max sum of array such that no two elements are
	// adjacent.
	public int getMaximum(int a[]) {
		int inc = a[0];
		int exc = 0;
		int excNew;

		for (int i = 1; i < a.length; i++) {

			// current max excluding i
			excNew = max(inc, exc);

			// current max including i
			inc = exc + a[i];
			exc = excNew;
		}
		// return max out of inc and exc.
		return max(inc, exc);
	}

	// Max function, return max of two numbers.
	public int max(int a, int b) {
		if (a > b) {
			return a;
		} else
			return b;
	}

	public static void main(String[] args) {
		int a[] = { 5, 5, 10, 40, 50, 35 };

		MaxSumWithoutAdjacency object = new MaxSumWithoutAdjacency();
		System.out.print(object.getMaximum(a));
	}
}
