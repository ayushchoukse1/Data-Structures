package com.practice.algorithms.linkedlist;

public class PartitionLL {

	public static void main(String[] args) {
		// input= 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 
		// output= 3 ->1 -> 2 -> 10 -> 5 -> 5 -> 8
		
		LinkedList list = new LinkedList();
		
		list.insertLinkedList(3, 0);
		list.insertLinkedList(5, 1);
		list.insertLinkedList(8, 2);
		list.insertLinkedList(5, 3);
		list.insertLinkedList(10, 4);
		list.insertLinkedList(2, 5);
		list.insertLinkedList(1, 6);
		
		partition(list.getHead(), 5);
		
		list.displayLinkedList();
		
		
		
	}
	
	public static void partition(LinkedListNode head, int a){
		LinkedListNode node = new LinkedListNode(a);
		LinkedListNode head1 = head;
		LinkedListNode temp;
		LinkedListNode previous = head;
		LinkedListNode current = head.getNext();
		while(previous .getNext() != null){
			previous = current;
			current = current.getNext();
			if(current.getData() < a){
				//insert a beginning
				//temp=current;
				previous.setNext(current.getNext());
				current.setNext(head1);
				head=current;
				current=previous.getNext();
			}
			
		}
		
	}

}
