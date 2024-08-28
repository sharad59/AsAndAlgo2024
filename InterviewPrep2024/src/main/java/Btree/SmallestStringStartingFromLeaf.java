package Btree;

public class SmallestStringStartingFromLeaf {

	static String smallestString = "";

	public static String smallestFromLeaf(TreeNode root) {
		getSmallestString(root, "");
		return smallestString;

	}

	static void getSmallestString(TreeNode node, String currString) {

		if (node == null)
			return;

		currString = (char) (node.val + 'a') + currString;

		if (node.left == null && node.right == null) {
			if (smallestString.isEmpty() || currString.compareTo(smallestString) < 0)
				smallestString = currString;
		}

		getSmallestString(node.left, currString);
		getSmallestString(node.right, currString);

	}

	public static void main(String[] args) {

		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(0);
		a.right = new TreeNode(3);
		a.left.left = new TreeNode(2);
		a.left.right = new TreeNode(6);
		a.right.right = new TreeNode(3);
		String s = smallestFromLeaf(a);
		System.out.println(s);

	}
}
