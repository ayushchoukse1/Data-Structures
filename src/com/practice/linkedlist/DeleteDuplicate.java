package com.practice.linkedlist;

public class DeleteDuplicate {
	LinkedListNode head;
	int length = 0;

	public void deleteDups(LinkedListNode node) {
		// check if head is null. If yes, return.
		if (head == null)
			return;

		// Take two node pointers to keep track of duplicates.
		LinkedListNode previous = head;
		LinkedListNode current = previous.getNext();

		// Do the following until current gets null.
		while (current != null) {
			// Temporary node runner to iterate through LinkedList
			LinkedListNode runner = head;
			// until runner get equal to current node.
			while (runner != current) {

				// Check for earlier duplicates
				if (runner.getData() == current.getData()) {
					LinkedListNode tmp = current.getNext();
					// update current to next node
					current = tmp;
					break;
					// all other duplicates have already been removed
				}
				runner = runner.getNext();
			}
			if (runner == current) {
				// current not updated
				previous = current;
				current = current.getNext();
			}
		}
	}

}
