package Btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderWithDirectionChange {

	static class Node {
		Node left;
		int data;
		Node right;
	};

	static void modifiedLevelOrder(Node node) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			System.out.print(node.data);
			return;
		}

		Queue<Node> myQueue = new LinkedList<>();
		Stack<Node> myStack = new Stack<>();
		Node temp = null;
		int sz;
		int ct = 0;
		boolean rightToLeft = false;

		myQueue.add(node);

		while (!myQueue.isEmpty()) {
			ct++;

			sz = myQueue.size();

			for (int i = 0; i < sz; i++) {
				temp = myQueue.poll();
				if (rightToLeft == false)
					System.out.print(temp.data + " ");

				else
					myStack.push(temp);

				if (temp.left != null)
					myQueue.add(temp.left);

				if (temp.right != null)
					myQueue.add(temp.right);
			}

			if (rightToLeft == true) {

				while (!myStack.isEmpty()) {
					temp = myStack.pop();

					System.out.print(temp.data + " ");
				}
			}

			if (ct == 2) {
				rightToLeft = !rightToLeft;
				ct = 0;
			}

			System.out.print("\n");
		}
	}

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	public static void main(String[] args) {
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		root.left.left.left = newNode(8);
		root.left.left.right = newNode(9);
		root.left.right.left = newNode(3);
		root.left.right.right = newNode(1);
		root.right.left.left = newNode(4);
		root.right.left.right = newNode(2);
		root.right.right.left = newNode(7);
		root.right.right.right = newNode(2);
		root.left.right.left.left = newNode(16);
		root.left.right.left.right = newNode(17);
		root.right.left.right.left = newNode(18);
		root.right.right.left.right = newNode(19);

		modifiedLevelOrder(root);
	}
}
