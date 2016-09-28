package geekforgeeks.arrays;

public class SearchElementInSortedAndPivotedArray {

	/*
	 * An element in a sorted array can be found in O(log n) time via binary
	 * search. But suppose I rotate the sorted array at some pivot unknown to
	 * you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise
	 * a way to find an element in the rotated array in O(log n) time.
	 */
	public int getElement(int a[], int x, int length) {
		int pivot = getPivot(a, 0, length - 1);
		// check if pivot == -1.
		if (pivot == -1)
			return binarySearch(a, 0, length-1, x);
		//If found a pivot, then compare with pivot, if match return the pivot.
		if (a[pivot] == x)
			return pivot;
		//binary search in two subarrays recursively.
		if (a[0] < x)
			return binarySearch(a, 0, pivot - 1, x);
		else
			return binarySearch(a, pivot + 1, 0, x);
	}

	/* Standard Binary Search function */
	int binarySearch(int arr[], int low, int high, int no) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2; /* low + (high - low)/2; */
		if (no == arr[mid])
			return mid;
		if (no > arr[mid])
			return binarySearch(arr, (mid + 1), high, no);
		else
			return binarySearch(arr, low, (mid - 1), no);
	}

	public int getPivot(int a[], int low, int high) {

		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (high + low) / 2;
		// checks the right element of the mid. if right element is greater than
		// mid return the mid element.
		if (mid < high && a[mid] > a[mid + 1])
			return mid;
		// checks the left element of the mid. If the left element is greater
		// than
		// mid element return the greater element.
		if (mid > low && a[mid] < a[mid - 1])
			return (mid - 1);
		// if first element is greater than or equal to the mid element find
		// pivot again between them elements.
		if (a[low] >= a[mid])
			return getPivot(a, low, mid - 1);
		else
			// else find the pivot after the mid element.
			return getPivot(a, mid + 1, high);
	}

	public static void main(String[] args) {
		// given array
		int a[] = { 3, 4, 5, 1, 2};
		// element to be searched in 'a'
		int x = 3;
		SearchElementInSortedAndPivotedArray object = new SearchElementInSortedAndPivotedArray();
		System.out.println(object.getElement(a, x, a.length));

	}
}
