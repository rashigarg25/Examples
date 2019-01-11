package com.practice.odd.even;

public class Odd implements Runnable {

	private OddEvenPrinter oep;

	public Odd(OddEvenPrinter oep) {
		super();
		this.oep = oep;
	}

	@Override
	public void run() {
		oep.printOdd();

	}

}
