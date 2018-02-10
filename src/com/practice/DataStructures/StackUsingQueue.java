package com.practice.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int a) {
		if (q2.isEmpty()) {
			q1.offer(a);
		} else if (q1.isEmpty()) {
			q2.offer(a);
		}
	}

	public int pop() {
		int len1 = q1.size();
		int len2 = q2.size();
		if (!q1.isEmpty()) {
			for (int i = 0; i < len1 - 1; i++) {
				q2.offer(q1.poll());
			}
			return q1.poll();
		} else {
			for (int i = 0; i < len2 -1; i++) {
				q1.offer(q2.poll());
			}
			return q2.poll();
		}
	}

	public void printQueue() {
		if (!q1.isEmpty()) {
			while (!q1.isEmpty())
				System.out.print(q1.poll() + " ");
		} else {
			while (!q2.isEmpty())
				System.out.print(q2.poll() + " ");
		}
	}
}
