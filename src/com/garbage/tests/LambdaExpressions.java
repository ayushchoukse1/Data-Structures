package com.garbage.tests;

public class LambdaExpressions {
	@FunctionalInterface
	interface HelloService {
		String hello(String firstname, String lastname);
		static void method1() {
			System.out.println("test");
		};
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.runtime.version"));
		HelloService helloService = (String firstname, String lastname) -> {
			String hello = "Hello " + firstname + " " + lastname;
			return hello;
		};
		System.out.println(helloService.hello("ayush", "Choukse"));
		
	}

}