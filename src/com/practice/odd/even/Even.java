package com.practice.odd.even;

public class Even implements Runnable {

	private OddEvenPrinter oep;

	public Even(OddEvenPrinter oep) {
		super();
		this.oep = oep;
	}

	@Override
	public void run() {
		oep.printEven();
	}
}
