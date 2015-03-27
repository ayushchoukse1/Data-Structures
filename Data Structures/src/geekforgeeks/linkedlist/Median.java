package geekforgeeks.linkedlist;

import java.awt.List;

public class Median {

	/* Find the Median of the Linked List. */

	// This method returns the Median of the LinkedList.
	public LinkedListNode medianNode(LinkedListNode head) {

		// Initialize two linkedList nodes and make head point them.
		LinkedListNode slower = head;
		LinkedListNode faster = head;
		if (head != null) {

			// Run until faster next node and the node next to it does not gets
			// null
			while (faster.getNext() != null
					&& faster.getNext().getNext() != null) {
				// Increment slower node one at a time, and faster node two at a
				// time.
				slower = slower.getNext();
				faster = faster.getNext().getNext();
			}
		}
		return slower;
	}
}