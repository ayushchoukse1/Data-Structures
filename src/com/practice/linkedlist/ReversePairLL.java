package com.practice.linkedlist;

public class ReversePairLL {
	public LinkedListNode ReversePair(LinkedListNode current) {
		if (current == null || current.getNext() == null) {
			return null;
		}else{
			swap(current,current.getNext());
			current.getNext().setNext(ReversePair(current.getNext().getNext()));
		}
		return current;
	}

	public void swap(LinkedListNode current, LinkedListNode next) {
		LinkedListNode temp;
		temp = next;
		current.setNext(temp.getNext());
		temp.setNext(current);
		current = temp;
	}
}