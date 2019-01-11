package com.practice.sender.receiver;

public class Data {

	private StringBuffer message;
	private boolean dataUpdated;

	public Data(StringBuffer message, boolean dataUpdated) {
		super();
		this.message = message;
		this.dataUpdated = dataUpdated;
	}

	public StringBuffer getMessage() {
		return message;
	}

	public void setMessage(StringBuffer message) {
		this.message = message;
	}

	public boolean isDataUpdated() {
		return dataUpdated;
	}

	public void setDataUpdated(boolean dataUpdated) {
		this.dataUpdated = dataUpdated;
	}

}
