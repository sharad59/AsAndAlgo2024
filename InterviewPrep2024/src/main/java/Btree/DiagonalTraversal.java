package Btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal {

	public static List<Integer> diagonal(Node root) {
		List<Integer> diagonalVals = new ArrayList<>();
		if (root == null)
			return diagonalVals;

		Queue<Node> leftQueue = new LinkedList<>();
		Node node = root;

		while (node != null) {

			diagonalVals.add(node.key);

			if (node.left != null)
				leftQueue.add(node.left);

			if (node.right != null)
				node = node.right;
			else {

				if (!leftQueue.isEmpty()) {
					node = leftQueue.peek();
					leftQueue.remove();
				} else {
					node = null;
				}
			}
		}
		return diagonalVals;
	}

	public static void main(String[] args) {

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		List<Integer> diagonalValues = diagonal(root);
		for (int i = 0; i < diagonalValues.size(); i++) {
			System.out.print(diagonalValues.get(i) + " ");
		}
		System.out.println();
	}
}
