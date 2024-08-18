package Btree;

public class BoundryOrderTraversal {

	void printLeftLeaves(Node node) {
		if (node == null)
			return;
		if (node.left != null) {
			System.out.println(node.key);
			printLeftLeaves(node.left);
		} else if (node.right != null) {
			System.out.println(node.key);
			printLeftLeaves(node.right);
		}
	}

	void printRightLeaves(Node node) {
		if (node == null)
			return;
		if (node.right != null) {
			printRightLeaves(node.right);
			System.out.println(node.key);
		} else if (node.left != null) {
			printRightLeaves(node.left);
			System.out.println(node.key);
		}

	}

	void printLeaves(Node node) {
		if (node == null)
			return;

		printLeaves(node.left);
		if (node.left == null && node.right == null) {
			System.out.println(node.key);
		}
		printLeaves(node.right);
	}

	void printBoundryTraveral(Node node) {
		if (node == null) {
			return;
		}
		printLeftLeaves(node);
		printLeaves(node);
		printRightLeaves(node.right);
	}

	public static void main(String args[]) {
		
		BoundryOrderTraversal a = new BoundryOrderTraversal();
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		a.printBoundryTraveral(root);
	}
}
