package com.practice.odd.even;

public class ThreadCreation {

	public static void main(String[] args) {

		OddEvenPrinter oep = new OddEvenPrinter();

		Thread odd = new Thread(new Odd(oep));
		Thread even = new Thread(new Even(oep));
		odd.start();
		even.start();
	}
}
