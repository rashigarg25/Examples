package com.practice.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		// 1->3->30->90->120->240->511
		ll.add(1);
		ll.add(3);
		ll.add(30);
		ll.add(90);
		ll.add(120);
		ll.add(240);
		// ll.add(511);
		ll.print();

		// ll.reverse();

		LinkedList<Integer> ll1 = new LinkedList<>();
		// 0->3->12->32->90->125->240->249
		ll1.add(0);
		ll1.add(3);
		ll1.add(12);
		ll1.add(32);
		ll1.add(90);
		ll1.add(125);
		ll1.add(240);
		ll1.add(249);
		ll1.print();

		LinkedList<Integer> newLL = maxSumLL(ll, ll1);
		newLL.print();
	}

	public static LinkedList<Integer> maxSumLL(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {

		LinkedList<Integer> newLL = new LinkedList<>();

		Node<Integer> startNode1 = ll1.getHead();
		Node<Integer> startNode2 = ll2.getHead();

		Node<Integer> tempNode1 = null, tempNode2 = null;

		int sum1 = 0, sum2 = 0;

		while (startNode1 != null || startNode2 != null) {

			if (startNode2 == null || startNode1.getData().compareTo(startNode2.getData()) < 0) {
				sum1 += startNode1.getData();
				startNode1 = startNode1.getNext();
			} else if (startNode1 == null || startNode1.getData().compareTo(startNode2.getData()) > 0) {
				sum2 += startNode2.getData();
				startNode2 = startNode2.getNext();
			} else {

				Node<Integer> bigSumNode = null;
				if (sum1 > sum2) {
					bigSumNode = tempNode1 == null ? ll1.getHead() : tempNode1;
				} else {
					bigSumNode = tempNode2 == null ? ll2.getHead() : tempNode2;
				}

				addToNewLL(newLL, bigSumNode, startNode1.getData());

				sum1 = 0;
				sum2 = 0;
				startNode1 = startNode1.getNext();
				startNode2 = startNode2.getNext();
				tempNode1 = startNode1;
				tempNode2 = startNode2;

			}
		}

		Node<Integer> bigSumNode = null;
		if (sum1 > sum2) {
			bigSumNode = tempNode1 == null ? ll1.getHead() : tempNode1;
		} else {
			bigSumNode = tempNode2 == null ? ll2.getHead() : tempNode2;
		}

		addToNewLL(newLL, bigSumNode, Integer.MAX_VALUE);
		return newLL;
	}

	private static void addToNewLL(LinkedList<Integer> newLL, Node<Integer> bigSumNode, int intersectionData) {

		while (bigSumNode != null && bigSumNode.getData() <= intersectionData) {
			newLL.add(bigSumNode.getData());
			bigSumNode = bigSumNode.getNext();
		}

	}

}
