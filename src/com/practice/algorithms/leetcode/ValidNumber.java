package com.practice.algorithms.leetcode;

public class ValidNumber {
	public int eCount = 0;
	public int decimalCount = 0;
	public int otherChar = 0;
	public int signCount = 0;
	public int falseCount = 0;

	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("3."));
	}

	public boolean isNumber(String s) {
		// System.out.println(s.length());
		if (s == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(s);
	        System.out.println("this ran" + d);
	        if(d/d==1) {
	        	return true;
	        }
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
		boolean result = false;
		boolean[] validChecks = new boolean[s.length()];
		int firstDigit = 0;
		char[] num = s.toCharArray();
		if (s.length() == 1) {
			return Character.isDigit(s.charAt(0));
		}
		if (num[0] == '-' || num[0] == '+') {
			signCount = 1;
			firstDigit = 1;
			validChecks[0] = true;
		}
		if (num[0] == '.') {
			decimalCount = 1;
			firstDigit = 1;
			validChecks[0] = true;
		}
		
		for (int i = num.length - 1; i >= firstDigit; i--) {
			validChecks[i] = checkValid(num[i], i, num);
		}
		for (boolean b : validChecks) {
			//System.out.println(b);
			if (b == false) {
				falseCount++;
			}
		}
		if (falseCount == 0)
			return true;
		else
			return false;
	}

	public boolean checkValid(char c, int i, char[] num) {
		if (Character.isDigit(c) || c == ' ') {
			return true;
		} else if (c == '.') {
			if (i == num.length - 1 || i == 0 || decimalCount >= 1) {
				return false;
			}
			if (Character.isDigit(num[i + 1]) && Character.isDigit(num[i - 1])) {
				decimalCount++;

				return true;
			}
		} else if (c == 'e') {
			if (i == num.length - 1 || i == 0 || eCount >= 1 || decimalCount > 0) {
				// System.out.println("this");
				return false;
			}
			if (Character.isDigit(num[i + 1]) && Character.isDigit(num[i - 1])) {
				// System.out.println("eCount = " + eCount);
				eCount++;
				return true;
			}
		}
		return false;
	}
}
