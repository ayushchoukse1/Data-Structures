package com.practice.algorithms.arrays;

import java.util.Stack;

public class SumOfTwoBigNumbers {

	public static void main(String[] args) {
		String number1 = "543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908";
		String number2 = "543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908543697829085436978290854369782908";
		SumOfTwoBigNumbers obj = new SumOfTwoBigNumbers();
		System.out.println(obj.addTwo(number1, number2));
	}

	public static String addTwo(String n1, String n2) {
		StringBuilder result = new StringBuilder("");
		int carryOver = 0;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		int biggerLength = 0;
		int diff = 0;
		if (n1.length() > n2.length()) {
			diff = n1.length() - n2.length();
			for (int i = 0; i < diff; i++) {
				s2.add(0);
			}
			biggerLength = n1.length();
		} else if (n1.length() < n2.length()) {
			diff = n2.length() - n1.length();
			for (int i = 0; i < diff; i++) {
				s1.add(0);
			}
			biggerLength = n2.length();
		}
		for (int i = 0; i < n1.length(); i++)
			s1.add(Integer.parseInt(Character.toString(n1.charAt(i))));

		for (int i = 0; i < n2.length(); i++)
			s2.add(Integer.parseInt(Character.toString(n2.charAt(i))));

		while (biggerLength != 0) {
			int temp1 = s1.pop();
			int temp2 = s2.pop();
			int sum = 0;
			if (carryOver > 0) {
				sum = temp1 + temp2 + carryOver;
				carryOver = 0;
			} else
				sum = temp1 + temp2;

			if (sum > 0) {
				s3.push(sum % 10);
				sum = sum / 10;
				carryOver = sum;
			} else {
				s3.push(sum);
			}
			biggerLength--;
		}
		while (!s3.isEmpty()) {
			result.append(s3.pop());
		}
		return result.toString();
	}
}
