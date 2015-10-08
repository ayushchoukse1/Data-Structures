package geekforgeeks.arrays;

public class CountInversions {
	// count the number of inversions required for an array to get sorted.

	/*
	 * possible solution: start from left taking left most element as the
	 * shortest element and compare with the right elements. every element
	 * smaller than the min element is the number of inversion required for the
	 * given integer array.
	 */
	
	//TIME COMPLEXITY- O(n*n)
	public int countInversion(int a[]) {
		// increment count everytime you find a element smaller than current.
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				if (a[i] > a[j]) {
					count++;
					System.out.println("(" + a[i] + "," + a[j] + ")");
				}
			}

		}
		return count;
	}

	public static void main(String[] args) {
		// sample array
		int a[] = { 2, 4, 1, 3, 5 };
		CountInversions object = new CountInversions();
		System.out.println(object.countInversion(a));
	}

}
