package com.practice.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public BstNode insert(BstNode root, int data) {
		if (root == null) {
			root = new BstNode();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		} else {
			if (data < root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
			} else {
				root.setRight(insert(root.getRight(), data));
			}
		}
		return root;
	}

	public BstNode delete(BstNode root, int data) {

		if (root == null) // return null if root empty.
			System.out.println("Empty Tree");
		else if (data < root.getData()) // if data is small than root find in left
			delete(root.getLeft(), data);
		else if (data > root.getData()) // if data is greater than find in right.
			delete(root.getRight(), data);
		else { // else its found, now delete the node.

			if (root.getLeft() != null && root.getRight() != null) {// if the node has two child nodes.
				BstNode temp = root;
				BstNode minFromRight = getMin(root.getRight());
				root.setData(minFromRight.getData());
				delete(temp.getRight(), minFromRight.getData());
			}
			if (root.getLeft() != null)
				root = root.getLeft();
			if (root.getRight() != null)
				root = root.getRight();
		}
		return root;
	}

	private BstNode getMin(BstNode root) {
		int min = Integer.MAX_VALUE;
		BstNode minNode = root;
		Queue<BstNode> q = new LinkedList<BstNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BstNode temp = q.poll();
			if (temp.getData() < minNode.getData())
				minNode.setData(temp.getData());
			if (temp.getLeft() != null)
				q.offer(temp.getLeft());
			if (temp.getRight() != null)
				q.offer(temp.getRight());
		}
		return minNode;
	}

	public static void levelOrderBst(BstNode root) {
		System.out.println();
		Queue<BstNode> q = new LinkedList<BstNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BstNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			System.out.print(temp.getData() + " ");
		}
	}

	public boolean isBst(BstNode root) {
		if (root == null)
			return true;
		if (root.getLeft() != null && root.getLeft().getData() > root.getData())
			return false;
		if (root.getRight() != null && root.getRight().getData() < root.getData())
			return false;
		if (!isBst(root.getLeft()) || !isBst(root.getRight()))
			return false;
		return true;
	}

	public void insertBst(BstNode root, int a) {

	}
}
