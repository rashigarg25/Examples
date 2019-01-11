package com.practice.multithreading;

public class ThreadClass implements Runnable {

	public CriticalSectionClass csc;

	public ThreadClass(CriticalSectionClass csc) {
		this.csc = csc;
	}

	@Override
	public void run() {
		try {
			System.out.println("Invoked from " + Thread.currentThread().getId());
			csc.cricticalMethod1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
