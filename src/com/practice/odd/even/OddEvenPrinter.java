package com.practice.odd.even;

public class OddEvenPrinter {

	private int i = 0;
	private boolean isOdd = false;

	public synchronized void printOdd() {

		try {
			while (i < 10) {
				if (!isOdd) {
					wait();
				}
				System.out.println("Odd -> " + i);
				i++;
				isOdd = false;
				notifyAll();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void printEven() {

		try {
			while (i <= 10) {
				if (isOdd) {
					wait();
				}
				System.out.println("Even -> " + i);
				i++;
				isOdd = true;
				notifyAll();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
