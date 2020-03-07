package com.practice.DataStructures;

public class MaxHeap {
	public final int capacity;
	public int[] a;
	public int length = 0;

	MaxHeap(int size) {
		capacity = size;
		a = new int[size];
	}

	public void insert(int element) {
		if (length == capacity) // if full, sysout
			System.out.println("capacity reached ");
		else {
			a[length] = element;
			length++;
			percolateUp();
		}
	}

	public void percolateUp() {
		int child = length - 1;
		int parent = (child - 1) / 2;
		while (a[parent] < a[child])
			// check parent and swap
			if (a[child] > a[parent]) {
				// swap parent child
				swap(child, parent);
				child = parent;
				parent = (child - 1) / 2;
			}
	}

	public int[] getHeap() {
		return a;
	}

	public int delete() {
		int temp = 0;
		if (length <= 0) {
			System.out.println("empty heap ! can't delete anything.");
		} else {
			temp = a[0];
			a[0] = a[length - 1]; // replace top value with last value and percolate down,
			a[length - 1] = -1;
			length--; // reduce the size
			percolateDown();
		}
		return temp;
	}

	public void percolateDown() {
		int i = 0;
		int left = (2 * i) + 1;
		while (left < length) {
			int maxChild = left;
			int right = (2 * i) + 2;
			if (right < length) {
				if (a[right] > a[maxChild])
					maxChild = right;
			}
			if (a[maxChild] > a[i]) {
				swap(i, maxChild);
				i = maxChild;
				left = (2 * i) + 1;
			} else
				break;
		}
	}

	public void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(10);
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i : a) {
			mh.insert(i);
		}
		System.out.println("deleting = " + mh.delete());
		System.out.println("deleting = " + mh.delete());
		System.out.println("deleting = " + mh.delete());
		System.out.println("deleting = " + mh.delete());
		System.out.println("deleting = " + mh.delete());
		int[] heapt = mh.getHeap();
		for (int i = 0; i < heapt.length; i++) {
			System.out.print(" " + heapt[i]);
		}

	}
}
