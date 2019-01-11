package com.practice.linkedlist;

public class LinkedList<T> {

	private Node<T> head;

	public Node<T> getHead() {

		return head;
	}

	public void add(T value) {

		Node<T> newNode = new Node<T>(value);

		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> temp = head;
		while (null != temp.getNext()) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
	}

	public void print() {
		Node<T> temp = head;
		while (null != temp) {
			System.out.print(" -> " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void reverse() {

		if (null == head.getNext()) {
			return;
		}

		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = current.getNext();

		while (current.getNext() != null) {
			current.setNext(prev);
			prev = current;
			current = next;
			next = next.getNext();
		}
		current.setNext(prev);
		head = current;
	}

	public void reverseNGroup(int n) {

	}

}
