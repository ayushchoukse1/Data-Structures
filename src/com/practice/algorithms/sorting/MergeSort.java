package com.practice.algorithms.sorting;

public class MergeSort {
	public static int[] b;

	public static void mergeSort(int[] a, int lb, int ub) {
		if (lb < ub) {
			int mid = (lb + ub) / 2;
			mergeSort(a, lb, mid);
			mergeSort(a, mid + 1, ub);
			merge1(a, lb, mid, ub);
		}
	}

	public static void merge(int a[], int lb, int mid, int ub) {
		System.out.println("l= " + lb + " m= " + mid + " h= ");
		int i = lb;
		int j = mid + 1;
		int k = lb;
		while (i <= mid && j <= ub) {
			if (a[i] <= a[j]) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}
		if (i > mid) {
			while (j <= ub) {
				b[k] = a[j];
				j++;
				k++;
			}
		} else {
			while (i <= mid) {
				b[k] = a[i];
				i++;
				k++;
			}
		}
	}
	static void merge1(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  

	public static void main(String[] args) {
		// MergeSort ms = new MergeSort();
		int a[] = { 10, 3, 5, 62, 77, 4, 7, 80, 0, 2, 8 };

		b = new int[a.length];
		System.out.println(b.length);
		MergeSort.mergeSort(a, 0, a.length-1);
		for (int i : b) {
			System.out.print(i + " ");
		}
	}
}
