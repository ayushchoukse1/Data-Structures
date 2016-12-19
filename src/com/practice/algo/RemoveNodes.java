package com.practice.algo;

import com.practice.linkedlist.LinkedList;
import com.practice.linkedlist.LinkedListNode;

public class RemoveNodes {

	/*public static LinkedListNode remove(LinkedListNode list, int x) {
		// assume provided node is a head node of the linked list.
		if (list == null) {
			System.out.println("node is null");
			return null;
		}
		int position =0;
		LinkedListNode head = list;
		LinkedListNode current = list;
		LinkedListNode previous = null;
	
		while (head.getNext() != null) {
			// System.out.println("Before = " + head.getData());
			if (head.getData() > x) {
				head = head.getNext();
				previous = head.getNext();
				// System.out.println("AFter = " + head.getData());
				current = head.getNext().getNext();
	
			} else if (head.getData() <= x) {
	
				// previous = head;
				// current= head.getNext();
				break;
			}
		}
		// System.out.println(head.getData());
		while (current.getNext() != null) {
			if (current.getData() > x) {
				System.out.println("current" + current.getData());
				previous.setNext(current.getNext());
				current = current.getNext();
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		return head;
	}
	*/
	static LinkedListNode removeNodes(LinkedListNode list, int x) {
		LinkedListNode prev = null;
		LinkedListNode curr = list;
		LinkedListNode head = list;
		while (curr != null) {
			if (curr.getData() > x) {
				if (prev == null) {
					head = head.getNext();
					curr = curr.getNext();
				} else {
					prev.setNext(curr.getNext());
					curr = curr.getNext();
				}
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}

		return head;

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		// LinkedList linkedList2 =new LinkedList();
		// LinkedList1
		linkedList.insertLinkedList(5, 0);
		linkedList.insertLinkedList(2, 1);
		linkedList.insertLinkedList(6, 2);
		linkedList.insertLinkedList(2, 3);
		linkedList.insertLinkedList(5, 4);
		linkedList.insertLinkedList(1, 5);
		linkedList.insertLinkedList(2, 6);
		linkedList.insertLinkedList(3, 7);
		linkedList.insertLinkedList(3, 8);
		linkedList.insertLinkedList(6, 9);
		linkedList.insertLinkedList(3, 10);
		linkedList.insertLinkedList(2, 11);
		// linkedList.displayLinkedList();
		System.out.println("head: " + linkedList.getHead().getData());
		printList(removeNodes(linkedList.getHead(), 3));

	}

	public static void printList(LinkedListNode node) {
		// System.out.println(node.getData());
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();

		}
	}

	/*public void deleteLinkedList(int position) {
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
	
	}*/

}
