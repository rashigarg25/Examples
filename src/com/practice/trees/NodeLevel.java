package com.practice.trees;

public class NodeLevel {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.createTree();

		int level = getLevel(tree.getRoot(), 55, 1);

		System.out.println(level);

	}

	private static int getLevel(Node n, int dataToBeChecked, int level) {

		if (n == null) {
			return 0;
		}

		if (n.data == dataToBeChecked) {
			return level;
		}

		int l = getLevel(n.left, dataToBeChecked, level + 1);

		if (l != 0) {
			return l;
		}

		l = getLevel(n.right, dataToBeChecked, level + 1);
		return l;
	}

}
