package com.practice.algo;

import java.util.EmptyStackException;

public class Stack {
	protected int capacity;
	protected final int MAX_CAPACITY = 50;
	int[] array;
	int top;

	public Stack() {
		// initializing with default constructor.
		this.array = new int[MAX_CAPACITY];
	}

	public Stack(int cap) {
		// initializing with a given capacity;
		this.capacity = cap;
		array = new int[this.capacity];
		this.top = -1;
	}

	public void push(int i) {
		// check before pushing if the stack is full.
		if (size() == capacity)
			throw new StackOverflowError("Stack full, cannot insert.");
		this.array[++top] = i;
	}

	public int pop() {
		if(isEmpty())
			throw new EmptyStackException();
		int i = this.array[top];
		array[top--] = Integer.MIN_VALUE;
		return i;
	}

	public int top() {
		if(isEmpty())
			throw new EmptyStackException();
		return this.array[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public boolean isFull() {
		return (size() == capacity);
	}
}
