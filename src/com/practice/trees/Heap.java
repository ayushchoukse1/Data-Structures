package com.practice.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Heap {

	/*
	 * properties of heap
	 * 1. has count;
	 * 2. has capacity
	 * 3. has a parent
	 * 4. has a left child
	 * 5. has a right child
	 * 6. returns maxelement
	 * 7. return minelement
	 * 8. has heapType.
	 */
	private int cap = 0;
	private int count = 0;
	private int[] arr = null;

	public Heap(int cap) {
		this.cap = cap;
		this.count = 0;
		this.arr = new int[this.cap];
	}

	public void insert(int data) {
		if (this.count >= this.cap) {
			throw new NoSuchElementException("Heap has reached to its max capacity.");
		}
		this.arr[this.count++] = data;
		percolateUp(this.count - 1);
	}

	private void percolateUp(int i) {
		int k = i;
		while (k > 0) {
			int p = (k - 1) / 2;
			if (this.arr[k] > this.arr[p]) {
				// swap if child is greater than parent
				int temp = this.arr[k];
				this.arr[k] = this.arr[p];
				this.arr[p] = temp;
				// increase the level to the parent node index.
				k = p;
			} else {
				break;
			}
		}
	}

	public int delete(int i) {
		if (this.count == 0) {
			throw new NoSuchElementException("Heap is empty.");
		}
		int temp = this.arr[i];
		this.arr[i] = this.arr[this.count - 1];
		count--;
		percolateDown(this.arr[i]);
		return temp;
	}

	private void percolateDown(int i) {
		int k = i;
		int max, l, r;
		l = this.arr[2 * i + 1];
		r = this.arr[2 * i + 2];
		if (l != -1 && l > this.arr[i]) {
			max = l;
		} else {
			max = this.arr[i];
		}
		if (r != 0 && r > max) {
			max =r;
		}
		if (max != this.arr[i]) {
			int temp = this.arr[i];
			this.arr[i]= max;
			max = temp;
		}
		percolateDown(max);
	}

}
