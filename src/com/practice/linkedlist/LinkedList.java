package com.practice.linkedlist;

import java.util.Hashtable;

public class LinkedList {
	LinkedListNode head;
	int length = 0;

	// Default constructor.
	public LinkedList() {

		this.head = null;
		length = 0;
	}

	public LinkedListNode getHead() {
		return head;
	}

	// Returns true if LinkedList is Empty.
	public boolean isEmpty() {

		return (head == null);
	}

	// This method returns the length of Linked List.
	public int getLength() {

		return length;

	}

	// This method creates loop in Linked List.
	public void createLoop() {
		LinkedListNode temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(head);
	}

	// This method inserts a new node in the linked list at the specified
	// position.
	public void insertLinkedList(int data, int position) {

		// Fix the position i.e if the given position is less then 0 or greater
		// than the length of linkedList.
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// Check if the list is empty, if yes then set the data as head node.
		if (head == null) {
			head = new LinkedListNode(data);
		}
		// Check if the given position is zero, that means we are adding at the
		// start.
		else if (position == 0) {
			LinkedListNode tempNode = new LinkedListNode(data);
			tempNode.setNext(head);
		}
		// Else go to the correct position and insert that node.
		else {
			LinkedListNode tempNode = head;
			for (int i = 1; i < position; i++) {
				tempNode = tempNode.getNext();
			}
			LinkedListNode newNode = new LinkedListNode(data);
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
		length++;
	}

	// This method deletes the node at specified position
	public void deleteLinkedList(int position) {
		// Fix the position.
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}
		// Return if head is null.
		if (head == null) {
			return;
		}
		// Delete head node.
		else if (position == 0) {
			head = head.getNext();

		}
		// Else traverse to the specified position and delete the node.
		else {
			LinkedListNode previous = head;

			for (int i = 1; i < position; i++) {
				previous = previous.getNext();

			}
			previous.setNext(previous.getNext().getNext());
		}
		length--;

	}

	// This method displays all the nodes in the Linked List.
	public void displayLinkedList() {
		LinkedListNode current = head;
		while (current != null) {
			current.displayNode();
			current = current.getNext();
		}

	}

	// This method returns the position of the data specified.
	public int getPosition(int data) {
		int nodePoistion = 0;
		LinkedListNode temp = head;
		while (temp.getNext() != null) {
			if (temp.getData() == data)
				return nodePoistion;
			temp = temp.getNext();
			nodePoistion++;
		}
		return nodePoistion;
	}

}
