package com.practice.prod.consumer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadFactory {

	public static void main(String[] args) {

		Queue<Integer> ll = new LinkedBlockingQueue<>();
		Thread t1 = new Thread(new Producer(ll));
		t1.start();
		Thread t2 = new Thread(new Consumer(ll));
		t2.start();

	}
}
