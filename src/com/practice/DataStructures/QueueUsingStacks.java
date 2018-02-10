package com.practice.DataStructures;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public void enqueue(int a) {
		if (s1.isEmpty()) {
			while (!s2.isEmpty())
				s1.push(s2.pop());
		}
		s1.push(a);
	}

	public int dequeue() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public void printQueue() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		while (!s2.isEmpty())
			System.out.print(s2.pop() + " ");
	}
}
