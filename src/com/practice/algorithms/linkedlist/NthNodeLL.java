package com.practice.algorithms.linkedlist;

public class NthNodeLL {
	public LinkedListNode findNthNodeFromStart(LinkedListNode head, int n) {
		if (head == null) {
			throw new NullPointerException();
		}
		if (n == 0) {
			// return first element.
			return head;
		}
		// iterate through LL n times to return nth element.
		LinkedListNode temp = head;
		for (int i = 0; i < n - 1; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	// Naive Approach 1
	// reverse the linked list and iterate for first nth elements

	// Naive Approach 2
	// iterate through table and store the position of each item in a hashtable.
	// At the end of the list, we have table with the positions and just need to
	// return m-n+1th term. but this takes O(m) space complexity as we need a
	// table of size equal to LL.s

	// One scan approach. Take two pointers and iterate one pointer nth times
	// and then move both pointers at the same time until one pointer reaches
	// the end.
	public LinkedListNode findNthNodeFromLastUsingTwoPointer(LinkedListNode head, int n) {
		if (head == null) {
			throw new NullPointerException();
		}
		if (n == 0) {
			// return first element.
			return head;
		}
		LinkedListNode tempNthNode = head;
		LinkedListNode tempLastNode = head;

		// First run tempLastNode n-1 times.
		for (int i = 0; i < n - 1; i++)
			if (tempLastNode != null)
				tempLastNode = tempLastNode.getNext();

		// Now iterate through the LL until tempLastNode reaches end.
		while (tempLastNode.getNext() != null) {
			if (tempNthNode == null) {
				tempNthNode = head;
			} else {
				tempNthNode = tempNthNode.getNext();
				tempLastNode = tempLastNode.getNext();
			}
		}
		return tempNthNode;
	}

}
