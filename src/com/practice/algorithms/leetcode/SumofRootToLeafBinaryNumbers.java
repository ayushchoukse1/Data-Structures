package com.practice.algorithms.leetcode;

import com.practice.DataStructures.BinaryTreeNode;

public class SumofRootToLeafBinaryNumbers {
	public static int[] result = new int[1000];
	public static int k = 0;

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(0);
		BinaryTreeNode two = new BinaryTreeNode(0);
		BinaryTreeNode three = new BinaryTreeNode(1);
		BinaryTreeNode four = new BinaryTreeNode(0);
		BinaryTreeNode five = new BinaryTreeNode(1);
		BinaryTreeNode six = new BinaryTreeNode(0);
		BinaryTreeNode seven = new BinaryTreeNode(1);

//		root.setLeft(two);
//		root.setRight(three);
//		two.setLeft(four);
//		two.setRight(five);
//		three.setLeft(six);
//		three.setRight(seven);
		sumRootToLeaf(root);
	}

	public static int sumRootToLeaf(BinaryTreeNode root) {
		int[] path = new int[1000];
		int total = 0;
		rootToLeafPath(root, path, 0);
		for (int i = 0; i < result.length; i++) {
			total = total + result[i];
		}
		System.out.println(total);
		return total;
	}

	public static void rootToLeafPath(BinaryTreeNode node, int[] path, int length) {
		if (node == null)
			return;
		path[length] = node.getData();
		length++;
		if (node.getLeft() == null && node.getRight() == null) {
			result[k] = printArray(path, length);
			k++;
		} else {
			rootToLeafPath(node.getLeft(), path, length);
			rootToLeafPath(node.getRight(), path, length);
		}
	}

	static int printArray(int ints[], int len) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str.append(ints[i]);
		}
		return Integer.parseInt(str.toString(), 2);
	}
}
