package geekforgeeks.arrays;

public class MissingNumber {

	/*
	 * You are given a list of n-1 integers and these integers are in the range
	 * of 1 to n. There are no duplicates in list. One of the integers is
	 * missing in the list. Write an efficient code to find the missing integer.
	 */
	public int getMissingNumber(int a[]) {
		//length of array.
		int n = a.length;
		
		// general sum of n numbers is (n * (n-1))/2
		int generalSum = (n * (n + 1)) / 2;
		int arraySum = 0;
		
		// sum of the given integers
		for (int i = 0; i < a.length - 1; i++) {
			arraySum += a[i];
		}
		// subtract the general sum of given integer array from sum of general n
		// integers.
		return generalSum - arraySum;
	}

	public static void main(String[] args) {
		// input String
		int a[] = { 1, 2, 4, 6, 3, 7, 8 };

		MissingNumber object = new MissingNumber();
		int result = object.getMissingNumber(a);
		System.out.println(result);
	}

}
