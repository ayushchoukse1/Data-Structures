package com.practice.algorithms.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	/*
	You are given two linked lists representing two non-negative numbers. 
	The digits are stored in reverse order and each of their nodes contain a single digit. 
	Add the two numbers and return it as a linked list.
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addLists(l1, l2, 0);
	}

	public ListNode addLists(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		ListNode result = new ListNode(0);
		int value = carry;
		if (l1 != null)
			value += l1.val;
		if (l2 != null)
			value += l2.val;
		result.val = value % 10;
		if (l1 != null || l2 != null) {
			ListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(6);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(7);
		l1.next=l2;
		l2.next=l3;
		
		ListNode r1 = new ListNode(2);
		ListNode r2 = new ListNode(9);
		ListNode r3 = new ListNode(5);
		r1.next=r2;
		r2.next=r3;
		
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode node = atn.addTwoNumbers(l1, r1);
		
		while(node.next != null){
			System.out.println(node.val+" -> ");
			node.next=node.next.next;
		}
	}

}
