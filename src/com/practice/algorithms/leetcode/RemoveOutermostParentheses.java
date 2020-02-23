package com.practice.algorithms.leetcode;

import java.util.Arrays;

public class RemoveOutermostParentheses {
	StringBuilder result = new StringBuilder("");

	public static void main(String[] args) {
		RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
		rop.removeOuterParentheses("(()())(())(()(()))");
	}

	public String removeOuterParentheses(String S) {
		if (S.length() == 0 || S.length() > 10000 || S.isEmpty())
			return "";
		int enclosing = 0;
		int open = 0;
		int outermost = 0;
		int l1 = 0;
		int l2 = 0;
		char[] c = S.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				if (open == 0) {
					outermost++;
					l1 = i;
				}
				open++;
			} else if (c[i] == ')') {
				open--;
				if (open > 0)
					enclosing++;
				if (open == 0 && enclosing > 0) {
					outermost--;
					l2 = i;
					printResult(c, l1 + 1, l2 - 1);
					enclosing = 0;
				}
			}
		}
		System.out.println(result);
		return result.toString();
	}

	public void printResult(char[] c, int l1, int l2) {
		for (int i = l1; i <= l2; i++) {
			result.append(c[i]);
		}
	}
}
