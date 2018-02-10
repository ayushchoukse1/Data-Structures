package com.practice.DataStructures;

public class Test {

	public static void main(String[] args) {
		System.out.print("Stack = ");
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(134);
		stack.push(16);
		// stack.pop();
		stack.push(17);
		stack.push(12);
		// stack.pop();
		// stack.pop();
		stack.push(18);
		stack.printStack();

		System.out.print("\nQueue = ");
		QueueUsingStacks q = new QueueUsingStacks();
		q.enqueue(1);
		q.enqueue(10);
		q.enqueue(35);
		q.enqueue(37);
		q.enqueue(9);
		q.enqueue(141);
		q.enqueue(19);
		q.enqueue(1925);
		q.printQueue();

		System.out.print("\nStack using queue = ");
		StackUsingQueue s = new StackUsingQueue();
		s.push(57);
		s.push(36);
		s.push(435);
		s.pop();
		s.push(73);
		s.push(18);
		s.pop();
		s.push(1234);
		s.push(728);
		s.push(64);
		s.push(835);
		s.printQueue();

		System.out.print("\nBinary Search Tree = ");
		BinarySearchTree bst = new BinarySearchTree();
		BstNode root = new BstNode();
		root.setData(2);
		bst.insert(root, 13);
		bst.insert(root, 1);
		bst.insert(root, 14);
		bst.insert(root, 22);
		bst.insert(root, 169);
		bst.insert(root, 20);
		bst.insert(root, 169);
		bst.delete(root, 6);
		bst.levelOrderBst(root);
		System.out.println("\nisBST = " + bst.isBst(root));
	}
}
