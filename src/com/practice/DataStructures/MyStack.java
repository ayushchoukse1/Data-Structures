package com.practice.DataStructures;

import java.util.EmptyStackException;

public class MyStack {
	final int CAPACITY = 100;
	int size = -1;
	int[] arr = new int[CAPACITY];

	public void push(int a) {
		if (size <= CAPACITY) {
			size++;
			arr[size] = a;
		} else {
			System.out.println("Stack Full");
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			int temp = arr[size];
			arr[size] = Integer.MIN_VALUE;
			size--;
			return temp;
		}
	}

	public boolean isEmpty() {
		if (size < 0)
			return true;
		return false;
	}

	public void printStack() {
		for (int i = size; i >= 0; i--)
			System.out.print(arr[i] + " ");
	}
}
