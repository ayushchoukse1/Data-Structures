package com.practice.algorithms.leetcode;

public class RunnerClass {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child();
		Child c1 = new Child();
		//Child c2 = new Parent();
		System.out.println("P1 is parent reference object that can hold the object of Parent only :"+p1.m1() +" "+p1.m2());
		System.out.println("P2 is parent reference object that can hold the object of child but cannot acces child methods : "+p2.m1()+" "+p2.m2());
		System.out.println("c1 is child reference object that can hold object of its type only and can access parent class methods too: "+ c1.c1()+" " + c1.c1("lol")+" " + c1.m1()+" "+ c1.m2());
	}
}
