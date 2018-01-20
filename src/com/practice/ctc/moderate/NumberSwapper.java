package com.practice.ctc.moderate;

public class NumberSwapper {

	public static void main(String[] args) {
		int a = 9;
		int b = 3;
		System.out.println("a => " + a + " ,b => " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a => " + a + " ,b => " + b);

		int x = 'a';
		int y = 'b';
		System.out.println("x => " + x + " ,y => " + y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x => " + x + " ,y => " + y);

	}

}
