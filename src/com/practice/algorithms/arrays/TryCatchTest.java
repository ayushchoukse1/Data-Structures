package com.practice.algorithms.arrays;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest obj = new TryCatchTest();
		System.out.println(obj.test());
	}

	public static int test() {
		try {
			System.out.println(100/0);
			//return "try";
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			//return "catch";
		} 
		 return 1;
	}

}
