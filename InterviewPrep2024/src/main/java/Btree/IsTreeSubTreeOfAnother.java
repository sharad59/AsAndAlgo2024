package Btree;

public class IsTreeSubTreeOfAnother {

	Node root1, root2;

	boolean areIdentical(Node root1, Node root2) {

		/* base cases */
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return (root1.key == root2.key && areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	boolean isSubtree(Node T, Node S) {
		/* base cases */
		if (S == null)
			return true;

		if (T == null)
			return false;

		if (areIdentical(T, S))
			return true;

		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	public static void main(String args[]) {
		IsTreeSubTreeOfAnother tree = new IsTreeSubTreeOfAnother();

		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);

		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(30);

		if (tree.isSubtree(tree.root1, tree.root2))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}
}
