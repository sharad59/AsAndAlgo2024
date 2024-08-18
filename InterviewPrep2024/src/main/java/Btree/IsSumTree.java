package Btree;

public class IsSumTree {

	static boolean isSumTree(Node node) {

		if (node == null || node.left == null && node.right == null)
			return true;

		if (node.key == sum(node.left) + sum(node.right)) {
			return true;
		} else
			return false;

	}

	static int sum(Node node) {
		if (node == null)
			return 0;
		return node.key + sum(node.left) + sum(node.right);

	}

	static int isLeaf(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return 0;
	}

	static int isSumTree1(Node node) {
		int ls;
		int rs;

		if (node == null || isLeaf(node) == 1)
			return 1;

		if (isSumTree1(node.left) != 0 && isSumTree1(node.right) != 0) {
			if (node.left == null)
				ls = 0;
			else if (isLeaf(node.left) == 1) 
				ls = node.left.key;
			else
				ls = 2 * (node.left.key);

			if (node.right == null)
				rs = 0;
			else if (isLeaf(node.right) == 1)
				rs = node.right.key;
			else
				rs = 2 * (node.right.key);

			if ((node.key == rs + ls))
				return 1;
			else
				return 0;
		}
		return 0;
	}

	public static void main(String args[]) {
		Node a = new Node(26);
		a.left = new Node(10);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(6);
		a.right.right = new Node(3);
		System.out.println(isSumTree1(a));
	}
}
