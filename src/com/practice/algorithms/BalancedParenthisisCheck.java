package com.practice.algorithms;

import java.util.Stack;

public class BalancedParenthisisCheck {
	public String checkBalance(String str) {

		if (str.isEmpty()) {
			return "EmptyString";
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '[' || ch == '(' || ch == '{') {
				stack.push(ch);
			} else if ((ch == ']' || ch == '}' || ch == ')') && (!stack.isEmpty())) {
				if (isPair(stack.peek(), ch)) {
					stack.pop();
				} else {
					return "Not Balanced";
				}
			} else {
				if ((ch == ']' || ch == '}' || ch == ')')) {
					return "Not Balanced";
				}
			}
		}
		if (stack.isEmpty())
			return "Balanced Parenthisis";
		else
			return "Not Balanced";
	}

	public boolean isPair(char open, char close) {

		if (open == '(' && close == ')')
			return true;
		else if (open == '{' && close == '}')
			return true;
		else if (open == '[' && close == ']')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String str = "([)]";
		if (str.isEmpty()) {
			System.out.println("Empty String");
			return;
		}
		BalancedParenthisisCheck bpc = new BalancedParenthisisCheck();
		System.out.println(bpc.checkBalance(str));
	}
}