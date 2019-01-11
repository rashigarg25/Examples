package com.practice.sender.receiver;

public class Sender implements Runnable {

	private Data data;

	public Sender(Data data) {

		this.data = data;
	}

	@Override
	public void run() {

		String arr[] = new String[] { "1", "2", "3", "4", "end" };
		int i = 0;

		while (i < arr.length) {
			synchronized (data.getMessage()) {
				try {

					if (data.isDataUpdated()) {
						data.getMessage().wait();
					}
					data.getMessage().replace(0, data.getMessage().length(), arr[i]);
					System.out.println("Sending -> " + data.getMessage());
					i++;
					data.setDataUpdated(true);
					data.getMessage().notifyAll();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}
