package Btree;

import java.util.*;

public class ReverseTreePath {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int value) {
			this.data = value;
		}
	};

	static void inorder(Node temp) {
		if (temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.data + " ");
		inorder(temp.right);
	}

	static void reverseTreePathUtil(Node root, ArrayList<Node> path, int pathLen, int key) {

		if (root == null)
			return;

		path.set(pathLen, root);
		pathLen++;

		if (root.data == key) {

			int i = 0, j = pathLen - 1;

			while (i < j) {
				int temp = path.get(i).data;
				path.get(i).data = path.get(j).data;
				path.get(j).data = temp;
				i++;
				j--;
			}
		}

		if (root.left == null && root.right == null)
			return;

		reverseTreePathUtil(root.left, path, pathLen, key);
		reverseTreePathUtil(root.right, path, pathLen, key);
	}

	static void reverseTreePath(Node root, int key) {
		if (root == null)
			return;

		ArrayList<Node> path = new ArrayList<Node>();
		for (int i = 0; i < 10; i++) {
			path.add(null);
		}
		reverseTreePathUtil(root, path, 0, key);
	}

	public static void main(String[] args) {
		Node root = new Node(7);
		root.left = new Node(6);
		root.right = new Node(5);
		root.left.left = new Node(4);
		root.left.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(1);

		/*
		 * 7 / \ 6 5 / \ / \ 4 3 2 1
		 */

		int key = 2;
		reverseTreePath(root, key);
		inorder(root);
	}
}
