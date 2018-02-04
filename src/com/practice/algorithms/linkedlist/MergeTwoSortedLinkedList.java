package com.practice.algorithms.linkedlist;

public class MergeTwoSortedLinkedList {

	public LinkedListNode mergeTwoSortedLinkedList(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		LinkedListNode head = new LinkedListNode(0);
		if (head1.getData() >= head2.getData()) {
			head = head2;
			head.setNext(mergeTwoSortedLinkedList(head1, head2.getNext()));
		} else {
			head = head1;
			head.setNext(mergeTwoSortedLinkedList(head1.getNext(), head2));
		}
		return head;
	}	
}
