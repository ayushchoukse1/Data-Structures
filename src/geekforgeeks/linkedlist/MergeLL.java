package geekforgeeks.linkedlist;

public class MergeLL {
	/* Merge Two sorted Linked List in m and n size into m+n size. */

	// This method returns the merged Linked List of m+n size.
	public LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode result = new LinkedListNode(0);

		// If either of the linked list is empty, return the other one.
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		// If data of head1 is less than or equal to the data of head 2.
		if (head1.getData() <= head2.getData()) {
			// set result as head1 and call the same function for the remaining
			// LinkedList and other Linked List.
			result = head1;
			result.setNext(merge(head1.getNext(), head2));
		} else {
			// Else set head2 as result and call
			result = head2;
			result.setNext(merge(head2.getNext(), head1));
		}
		return result;
	}

}
