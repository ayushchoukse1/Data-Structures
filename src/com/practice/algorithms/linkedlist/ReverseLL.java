package com.practice.algorithms.linkedlist;

public class ReverseLL {
	
	public static LinkedListNode reverseIterator(LinkedListNode head){
		LinkedListNode current=head;
		LinkedListNode previous=null;
		while (current != null) {
			LinkedListNode next=current.getNext();
			current.setNext(previous);
			previous=current;
			current=next;
		}
		return previous;
	}
}
