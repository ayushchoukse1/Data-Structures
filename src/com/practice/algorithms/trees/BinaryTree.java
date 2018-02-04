package com.practice.trees;

import java.util.ArrayList;
import java.util.Queue;

import java.util.LinkedList;

public class BinaryTree {
	public ArrayList<Integer> getMaxAtAllLevels(TreeNode root) {
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		// Level order the tree and add each element in the list.
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			treeList.add(temp.data);
			if (temp.left != null)
				q.add(temp.getLeft());
			if (temp.right != null)
				q.add(temp.getRight());
		}
		System.out.println(treeList);
		int levels = (int) (Math.log10(treeList.size() + 1) / Math.log10(2)) - 1;
		System.out.println(levels);
		for (int i = 0; i <= levels; i++) {
			int n = (int) (Math.pow(2, i));
			/*int max = Integer.MIN_VALUE;
			for (int j = n ; j < n; j++) {
				if (condition) {
					
				}
			}*/
			System.out.println(n);
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c2 = new TreeNode(2);
		TreeNode c3 = new TreeNode(3);
		TreeNode c4 = new TreeNode(4);
		TreeNode c5 = new TreeNode(5);
		TreeNode c6 = new TreeNode(6);
		TreeNode c7 = new TreeNode(7);
		root.left = c2;
		root.right = c3;
		c2.left = c4;
		c2.right = c5;
		c3.left = c6;
		c3.right = c7;
		BinaryTree o = new BinaryTree();
		o.getMaxAtAllLevels(root);
	}
}
