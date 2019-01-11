package com.practice.manual.deadlock;

public class DeadLockCreationMain {

	public static void main(String[] args) {

		String a = "a";
		String b = "b";

		Thread t1 = new Thread() {

			@Override
			public void run() {
				try {
					synchronized (a) {
						System.out.println("Thread 1, block 1");
						Thread.sleep(200);
						synchronized (b) {
							System.out.println("Inside Thread 1");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				try {
					synchronized (b) {
						System.out.println("Thread 2, block 1");
						Thread.sleep(200);
						synchronized (a) {
							System.out.println("Inside Thread 2");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
	}

}
