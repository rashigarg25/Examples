package com.practice.sender.receiver;

public class Receiver implements Runnable {

	private Data data;

	public Receiver(Data data) {
		this.data = data;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (data.getMessage()) {
				try {

					if (!data.isDataUpdated()) {
						data.getMessage().wait();
					}
					System.out.println("Reciveing -> " + data.getMessage());
					data.setDataUpdated(false);
					data.getMessage().notifyAll();
					if (data.getMessage().toString().equals("end"))
						break;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
