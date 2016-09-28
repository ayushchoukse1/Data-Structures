/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package geekforgeeks.linkedlist;

public class ReverseALinkedList {

	// This method reverses the linked list recursively
	public static void reverseLinkedListRecursive(LinkedListNode current,
			LinkedListNode[] head) {
		if (current == null) {
			return;
		}
		// base case
		LinkedListNode next = current.getNext();
		if (next == null) {
			head[0] = current;
			return;
		}
		reverseLinkedListRecursive(next, head);
		// Make next node points to current node
		next.setNext(current);
		
		// Remove existing link
		current.setNext(null);
	}

	// This method reverses the linked list Iteratively
	public static LinkedListNode reverseListIterative(LinkedListNode head) {

		// initially Current is head
		LinkedListNode current = head;

		// initially previous is null
		LinkedListNode prev = head;

		while (current != null) {
			// Save the next node
			LinkedListNode next = current.getNext();

			// Make current node points to the previous
			current.setNext(prev);

			// update previous
			prev = current;

			// update current
			current = next;
		}
		return prev;
	}
}
