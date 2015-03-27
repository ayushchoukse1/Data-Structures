package geekforgeeks.linkedlist;

public class LinkedListNode {

	private int data;
	private LinkedListNode next;

	// Parameterized constructor.
	public LinkedListNode(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	// setters and getters of data and next.
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	// This method prints out the data of node.
	public void displayNode() {

		System.out.print(" " + data + "  ---->");

	}

}
