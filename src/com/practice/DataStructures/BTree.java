package com.practice.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BTree {
	public void preOrder(Node root) {
		System.out.print("Pre-Order -> ");
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null)
				s.add(temp.right);
			if (temp.left != null)
				s.add(temp.left);
		}
	}
	
/*	  public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> values = new ArrayList<Integer>();
	        //base check
	        if(root == null)
	            return values;
	        
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode current = stack.pop();
	            values.add(0 , current.val);
	            //add left Child
	            if(current.left != null)
	                stack.push(current.left);
	            //add right Child
	            if(current.right != null)
	                stack.push(current.right);
	        }
	        return values;
	    }*/

	public void postOrder(Node root) {
		System.out.print("Post-Order -> ");
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.add(root);
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
			s2.push(temp);
		}
		while (!s2.isEmpty()) {
			System.out.print(" " + s2.pop().data);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.right.left = new Node(5);
		root.right.right = new Node(4);

		BTree tree = new BTree();
		tree.postOrder(root);
	}

}
