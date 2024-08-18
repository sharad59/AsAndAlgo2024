package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {
	int max_level = Integer.MIN_VALUE;

	void printRightOrder(Node node, int level) {

		if (node == null)
			return;

		if (level > max_level) {
			System.out.println(node.key);
			max_level = level;
		}
		printRightOrder(node.right, level + 1);
		printRightOrder(node.left, level + 1);

	}

	void rightView(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				Node curr = q.peek();
				q.remove();

				if (i == n - 1) {
					System.out.print(curr.key);
					System.out.print(" ");
				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}

	public static void main(String args[]) {
		RightView l = new RightView();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		l.printRightOrder(root, 0);

	}
}
