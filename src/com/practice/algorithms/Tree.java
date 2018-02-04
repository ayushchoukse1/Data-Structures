package com.practice.algorithms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Tree {
	static int counter;

	private static class TreeNode {
		TreeNode left;
		int item;
		TreeNode right;

		TreeNode(TreeNode left, int item, TreeNode right) {
			this.left = left;
			this.right = right;
			this.item = item;
		}
	}

	public static void createBST(int[] keys) {
		// set the value of counter;
		counter = 0;
		TreeNode root = null;
		// System.out.println(keys.length);
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < keys.length; i++) {
			set.add(keys[i]);
		}
		int index = 0;
		int[] keys1 = new int[set.size()];
		for (int i : set) {
			// System.out.println(i);
			keys1[index++] = i;
		}
		for (int i : keys1) {
			if (root != null) {

				insert(root, i);
			} else {

				// create root node for BST.
				root = new TreeNode(null, 2, null);
			}
			System.out.println(counter);
		}

	}

	public static void insert(TreeNode root, int key) {
		// increment the counter by 1;
		counter++;

		// key less than the value of root.
		if (key < root.item) {
			if (root.left == null) {
				TreeNode node = new TreeNode(null, key, null);
				root.left = node;
			} else {
				insert(root.left, key);
			}
		} else {
			if (root.right == null) {
				TreeNode node = new TreeNode(null, key, null);
				root.right = node;
			} else {
				insert(root.right, key);
			}
		}
	}

	public static void main(String[] args) {
		int[] keys = { 3, 2, 1, 3 };
		createBST(keys);
	}

}
