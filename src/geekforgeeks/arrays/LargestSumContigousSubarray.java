package geekforgeeks.arrays;

public class LargestSumContigousSubarray {

	public int getMaxSubarray(int a[]) {
		int max_ending_here = 0;
		int max_so_far = 0;
		// Loop for each element of the array
		for (int i = 0; i < a.length; i++) {

			// max_ending_here = max_ending_here+ a[i]
			max_ending_here = max_ending_here + a[i];

			// (b) if(max_ending_here < 0) max_ending_here = 0
			if (max_ending_here < 0)
				max_ending_here = 0;

			// (c) if(max_so_far < max_ending_here)
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;

	}

	public static void main(String[] arg) {
		// an array with negative elements also.
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		LargestSumContigousSubarray object = new LargestSumContigousSubarray();
		System.out.println(object.getMaxSubarray(a));

	}

}
