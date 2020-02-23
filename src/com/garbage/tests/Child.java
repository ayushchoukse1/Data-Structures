package com.garbage.tests;

public class Child extends Parent {
	public void m2(String s) {
		System.out.println("Child method m2 " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Child c = new Child();
		// Child c1= new Parent();
		Parent p1 = new Child();
		c.m1(new Object());
		c.m2("test");
		p.m2("test");
		int num = 12;
		System.out.println(num % 10);
		num = num / 10;
		System.out.println(num);
	}

}
