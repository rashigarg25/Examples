
package com.practice.trees;

public class BinaryTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node createTree() {



		/*
		 * 					  40
		 * 				   /       \
		 * 				  20       60
		 * 				 /  \     /  \
		 *              10  30   50  70
		 *             /          \
		 *            5            55
		 */
		

		root = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node5 = new Node(5);
		Node node45 = new Node(45);
		Node node55 = new Node(55);

		root.left = node20;
		root.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		node10.left = node5;
		node50.right = node55;
		return root;

	}

}
