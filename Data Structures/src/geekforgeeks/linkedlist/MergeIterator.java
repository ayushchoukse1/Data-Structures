package geekforgeeks.linkedlist;

public class MergeIterator {
	public LinkedListNode mergeIterator(LinkedListNode head1,
			LinkedListNode head2) {
		// create a head for the new list to be generated.
		// create a node to iterate through LL set it as head.
		LinkedListNode headNode = new LinkedListNode(0);
		LinkedListNode current = headNode;

		// repeat until both the lists are empty.
		while (head1 != null && head2 != null) {

			// if data of head1 is greater than data from head2
			if (head1.getData() <= head2.getData()) {

				// set head1 as current and update the head to next link.
				current.setNext(head1);
				head1 = head1.getNext();

			} else {

				// else do the same for head2. and update head to next link.
				current.setNext(head2);
				head2 = head2.getNext();
			}
		}

		// if head is not null then current next link as head1.
		if (head1 != null) {
			current.setNext(head1);
		}

		// else if head2is not null set current next as head 2.
		else if (head2 != null) {
			current.setNext(head2);
		}
		return headNode;
	}

}
