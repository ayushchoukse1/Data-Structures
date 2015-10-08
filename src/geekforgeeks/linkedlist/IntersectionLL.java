package geekforgeeks.linkedlist;

public class IntersectionLL {
	/*Check whether linked List merge or not.*/
	public int getIntesection(LinkedListNode list1, LinkedListNode list2) {
		// base conditions
		if (list1 == null || list2 == null) {
			System.out.println("one list is null");
		}
		LinkedListNode head1 = list1, head2 = list2;
		int length1 = 0, length2 = 0, diff = 0;

		// find lengths of both list
		while (head1.getNext() != null) {
			length1++;
			head1 = head1.getNext();
		}
		while (head1.getNext() != null) {
			length2++;
			head2 = head2.getNext();
		}

		// make head1 to point the bigger list and calculate the difference
		// between the lengths, say diff.
		if (length1 < length2) {

			head1 = list2;
			head2 = list1;
			diff = length2 - length1;
		} else {

			head1 = list1;
			head2 = list2;
			diff = length1 - length2;
		}

		// so that we can move diff steps in the longest list.
		for (int i = 0; i < diff; i++) {
			head1 = head1.getNext();
		}

		// after that move both list together.
		while (head1 != null && head2 != null) {
			if (head1.getData() == head2.getData()) {
				head1.displayNode();
				break;
			}
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		return head1.getData();
	}

}
