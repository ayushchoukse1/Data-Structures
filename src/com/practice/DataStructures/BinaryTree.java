package com.practice.DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public static void main(String args[]) {

		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode eight = new BinaryTreeNode(8);

		root.setLeft(two);
		root.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		seven.setRight(eight);
		System.out.println("PreOrder = ");
		BinaryTree.preOrder(root);
		System.out.println();
		System.out.println("InOrder = ");
		BinaryTree.inOrder(root);
		System.out.println();
		System.out.println("PostOrder = ");
		BinaryTree.postOrder(root);
		BinaryTree.levelOrder(root);
		BinaryTree.maxInBinaryTree(root);
		System.out.println(BinaryTree.findNode(root, 7));
		BinaryTree.reverseLevelOrder(root);
		System.out.println();
		System.out.println("height = " + BinaryTree.heightOfBinaryTree(root));
		BinaryTree.deepestBinaryTreeNode(root);
		System.out.println("\nno.of Leaf nodes = " + BinaryTree.noOfLeafNodes(root)); // noOfFullNodes
		System.out.println("\nno.of Full nodes = " + BinaryTree.noOfFullNodes(root));// maxWidthofBinaryTree
		System.out.println("\nmax width = " + BinaryTree.maxWidthofBinaryTree(root));
		BinaryTree.levelOrder(mirrorBinaryTree(root));
		System.out.println("\nLCA = ");
		System.out.println(BinaryTree.lowestCommonAncestor(root, four, eight).getData());
	}

	public static void preOrder(BinaryTreeNode root) { // DLR
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode current = stack.pop();
			System.out.print(current.getData() + " ");
			if (current.getRight() != null) {
				stack.push(current.getRight());
			}
			if (current.getLeft() != null) {
				stack.push(current.getLeft());
			}
		}
	}

	public static void inOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				BinaryTreeNode temp = stack.pop();
				System.out.print(temp.getData() + " ");
				current = temp.getRight();
			}
		}
	}

	public static void postOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				BinaryTreeNode temp = stack.peek().getRight();
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.getData() + " ");
					while (!stack.empty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
						System.out.print(temp.getData() + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public static void levelOrder(BinaryTreeNode root) {
		System.out.println();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			System.out.print(temp.getData() + " ");
		}
	}

	public static int lengthOfBinaryTree(BinaryTreeNode root) {
		int len = 0;

		System.out.println();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if (root != null) {
			len++;
			q.offer(root);
		}
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
				len++;
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
				len++;
			}
		}
		System.out.println(len);
		return len;
	}

	public static int maxInBinaryTree(BinaryTreeNode root) {
		int max = 0;
		System.out.println();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if (root != null) {
			max = root.getData();
			q.offer(root);
		}
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null) {
				if (temp.getLeft().getData() > max)
					max = temp.getLeft().getData();
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				if (temp.getRight().getData() > max)
					max = temp.getRight().getData();
				q.offer(temp.getRight());
			}
		}
		System.out.println("max Node = " + max);
		return max;
	}

	public static boolean findNode(BinaryTreeNode root, int a) {
		if (root == null) {
			return false;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
				if ((temp.getLeft().getData() == a))
					return true;
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
				if ((temp.getRight().getData() == a))
					return true;
			}
		}
		return false;
	}

	public static void reverseLevelOrder(BinaryTreeNode root) {
		System.out.println();
		Stack<Integer> s = new Stack<Integer>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			s.push(temp.getData());
		}
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
	}

	public static int heightOfBinaryTree(BinaryTreeNode root) {
		int height = 1;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}
			} else {
				if (!q.isEmpty()) {
					height++;
					q.offer(null);
				}
			}
			// System.out.print(temp.getData() + " ");
		}
		return height;
	}

	public static void deepestBinaryTreeNode(BinaryTreeNode root) {

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
		}
		System.out.println("deepestBinaryTreeNode = " + temp.getData());
	}

	public static int noOfLeafNodes(BinaryTreeNode root) {
		int number = 0;
		System.out.println();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() == null && temp.getRight() == null) {
				number++;
			}
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			System.out.print(temp.getData() + " ");
		}
		return number;
	}

	public static int noOfFullNodes(BinaryTreeNode root) {
		int number = 0;
		System.out.println();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.getLeft() != null && temp.getRight() != null) {
				number++;
			}
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
			System.out.print(temp.getData() + " ");
		}
		return number;
	}

	public static int maxWidthofBinaryTree(BinaryTreeNode root) {
		int max = 0;
		int count = 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			count++;
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}
			} else {
				if (count > max) {
					max = count;
				}
				count = 0;
				if (!q.isEmpty()) {

					q.offer(null);
				}
			}
			// System.out.print(temp.getData() + " ");
		}
		return max;
	}

	public static BinaryTreeNode mirrorBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if (root != null) {
			mirrorBinaryTree(root.getLeft());
			mirrorBinaryTree(root.getRight());
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}

	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null)
			return null;

		if (root == n1 || root == n2)
			return root;

		BinaryTreeNode left = lowestCommonAncestor(root.getLeft(), n1, n2);
		BinaryTreeNode right = lowestCommonAncestor(root.getRight(), n1, n2);

		// check not null
		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	public ArrayList<Integer> getMaxAtAllLevels(BinaryTreeNode root) {
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		// Level order the tree and add each element in the list.
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			treeList.add(temp.getData());
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
			if (temp.getRight() != null)
				q.add(temp.getRight());
		}
		System.out.println(treeList);
		int levels = (int) (Math.log10(treeList.size() + 1) / Math.log10(2)) - 1;
		System.out.println(levels);
		for (int i = 0; i <= levels; i++) {
			int n = (int) (Math.pow(2, i));
			/*
			 * int max = Integer.MIN_VALUE; for (int j = n ; j < n; j++) { if (condition) {
			 * 
			 * } }
			 */
			System.out.println(n);
		}
		return null;
	}
}
