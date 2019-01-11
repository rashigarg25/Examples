package com.practice.sender.receiver;

public class ThreadCreator {

	public static void main(String[] args) {

		Data data = new Data(new StringBuffer(), false);

		Thread sender = new Thread(new Sender(data));
		Thread reciever = new Thread(new Receiver(data));

		sender.start();
		reciever.start();
	}

}
