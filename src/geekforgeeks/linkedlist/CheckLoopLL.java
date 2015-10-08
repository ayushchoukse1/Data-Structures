package geekforgeeks.linkedlist;

public class CheckLoopLL {
	/* check whether the Given Linked List is cyclic or not. */

	public boolean checkLoop(LinkedListNode head) {

		// Initialize two LinkedListnodes faster and slower and set head point
		// them.
		LinkedListNode faster = head;
		LinkedListNode slower = head;

		// Increment the pointers until faster LinkedList node points to null
		while (faster.getNext() != null && faster.getNext().getNext() != null) {

			// Increment faster node two nodes at a time comparing to slower.
			faster = faster.getNext().getNext();

			// Increment slower node normally.
			slower = slower.getNext();

			// If slower and faster gets equal that means there is a cycle in
			// LinkedList. return true.
			if (slower == faster) {
				return true;
			}
		}
		return false;
	}

}
