package com.garbage.tests;

public class OLoading {
//	public static void m1(int i) {
//		System.out.println("int = " + i);
//	}

	public static void m1(double f) {
		System.out.println("double = " + f);
	}

//	public static void m3(Object o) {
//		System.out.println("Object " + o);
//	}

//	public static void m3(String s) {
//		System.out.println("String" + s);
//	}

	public static void m3(StringBuffer sb) {
		System.out.println("StringBuffer" + sb);
	}

	public static void m4(int a, double b) {
		System.out.println("int first " +a + b);
	}

	public static void m4(double a, int b) {
		System.out.println("long first " +a + b);
	}

	public static final synchronized strictfp void main(String... args) {
		OLoading mol = new OLoading();
		mol.m1(10);
		mol.m1(10.5);
		mol.m1('i');
		//mol.m3(new Object());
		//mol.m3("   test");
		mol.m3(null); 
		//mol.m3(new StringBuffer("SSBtest"));
		//mol.m4(4, 12); //ambiguous 
	}

}
