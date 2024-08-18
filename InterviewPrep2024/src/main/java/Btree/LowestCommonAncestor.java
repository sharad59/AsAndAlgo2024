package Btree;

public class LowestCommonAncestor {
	Node root;

	Node findNode(Node root, Node p, Node q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		Node left = findNode(root.left, p, q);
		Node right = findNode(root.right, p, q);

		if (left == null)
			return right;
		else if (right == null)
			return left;
		else {
			return root;
		}
	}

	public static void main(String args[]) {

		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(4, 5) = " + tree.findNode(tree.root, tree.root.left.left, tree.root.left.right).key);
		// System.out.println("LCA(4, 6) = " + tree.findNode(4, 6).data);
		// System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
		// System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
	}
}
