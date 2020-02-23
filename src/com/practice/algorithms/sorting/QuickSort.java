package com.practice.algorithms.sorting;

public class QuickSort {

	public void partition(int[] a, int low, int high) {

		if (a == null || a.length == 0)
			return;
		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = a[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			partition(a, low, j);

		if (high > i)
			partition(a, i, high);
	}

	public static void sort(int[] a, int start, int end) {
		if (start < end) {
			int pi = part(a, start, end);
			sort(a, start, pi - 1);
			sort(a, pi + 1, end);
		}
	}

	public static int part(int a[], int start, int end) {
		int partitionIndex = start;
		int pivot = a[end];
		for (int i = start; i <= end - 1; i++) {
			if (a[i] <= pivot) {
				int temp = a[i];
				a[i] = a[partitionIndex];
				a[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		int temp = a[end];
		a[end] = a[partitionIndex];
		a[partitionIndex] = temp;
		return partitionIndex;
	}

	public static void main(String[] args) {
		int[] a = { 10, 3, 5, 62, 77, 4, 7, 80, 0, 2, 8 };
		// QuickSort qs = new QuickSort();
		QuickSort.sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(" " + i);
		}
	}

}
