package com.practice.oops;

public class ImplicitTypecasting {

	public static void method(long l1, long l2) {
		System.out.println("Method1");
	}

	public static void method(double l1, double l2) {
		System.out.println("Method2");
	}

	public static void main(String args[]) {

		int a = 10;
		int b = 20;

		method(a, b);
	}

}
