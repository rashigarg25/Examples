package com.practice.multithreading;

public class CriticalSectionClass {

	public void cricticalMethod1() throws InterruptedException {

		synchronized (this) {
			System.out.println("Entered synch block: " + Thread.currentThread().getId());
			for (int i = 1; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("method 1 " + Thread.currentThread().getId());
			}
		}
		System.out.println("Exited synch block: " + Thread.currentThread().getId());
	}
}
