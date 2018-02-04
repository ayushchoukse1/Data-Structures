package com.practice.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SuccessiveConsecutiveNumber {
	
	private boolean findSuccessiveConsecutiveNumbers(Stack<Integer> s){
		Queue<Integer> q = new LinkedList<Integer>();
		while (!s.isEmpty()) {
			q.add(s.pop());
		}
		while(!q.isEmpty()){
			s.push(q.poll());
		}
		while(!s.isEmpty()){
			int n = s.pop();
			q.add(n);
			if (!s.isEmpty()) {
				int m = s.pop();
				q.add(m);
				if (Math.abs(m-n) != 1) {
					return false;
				}
			}
		}
		while (!q.isEmpty()) {
			s.push(q.poll());
		}
		return true;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(4);
		s.add(5);
		s.add(-2);
		s.add(-3);
		s.add(11);
		s.add(10);
		s.add(5);
		s.add(6);
		s.add(20);
		SuccessiveConsecutiveNumber obj = new SuccessiveConsecutiveNumber();
		System.out.println(obj.findSuccessiveConsecutiveNumbers(s));
	}

}
