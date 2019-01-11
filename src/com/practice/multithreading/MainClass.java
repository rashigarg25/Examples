package com.practice.multithreading;

public class MainClass {

	public static void main(String[] args) {

		CriticalSectionClass csc = new CriticalSectionClass();
		ThreadClass tc = new ThreadClass(csc);
		Thread t1 = new Thread(tc);
		t1.start();

		// tc.run();

		ThreadClass tc1 = new ThreadClass(csc);
		Thread t2 = new Thread(tc1);
		t2.start();

		/*
		 * Thread t2 = new Thread(new ThreadClass()); t2.start();
		 */
	}
}
