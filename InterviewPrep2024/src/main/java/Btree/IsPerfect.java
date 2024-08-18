package Btree;

public class IsPerfect {

	static int findADepth(Node node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	}

	static boolean isPerfectRec(Node root, int d, int level) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return (d == level + 1);

		if (root.left == null || root.right == null)
			return false;

		return isPerfectRec(root.left, d, level + 1) && isPerfectRec(root.right, d, level + 1);
	}

	static boolean isPerfect(Node root) {
		int d = findADepth(root);
		return isPerfectRec(root, d, 0);
	}

	public static void main(String args[]) {
		Node root = null;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		if (isPerfect(root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
