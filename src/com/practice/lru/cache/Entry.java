package com.practice.lru.cache;

public class Entry {

	private String key;
	private String value;
	private Entry left;
	private Entry right;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Entry getLeft() {
		return left;
	}

	public void setLeft(Entry left) {
		this.left = left;
	}

	public Entry getRight() {
		return right;
	}

	public void setRight(Entry right) {
		this.right = right;
	}

}
