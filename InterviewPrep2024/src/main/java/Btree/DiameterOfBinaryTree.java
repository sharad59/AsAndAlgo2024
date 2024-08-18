package Btree;

public class DiameterOfBinaryTree {
	
	static Node root=null;
	
	int diameter(Node root) {
		if (root == null)
			return 0;

		int lheight = height(root.left);
		int rheight = height(root.right);

		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	static int height(Node node) {
		if (node == null)
			return 0;
		return (1 + Math.max(height(node.left), height(node.right)));
	}
	
	 public static void main(String args[])
	    {
		 DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);

	        // Function Call
	        System.out.println(
	            "The diameter of given binary tree is : "
	            + tree.diameter1(root));
	    }
	 
	 class Height {
		    int h;
		}

		int diameterOpt(Node root, Height height) {

			Height lh = new Height(), rh = new Height();

			if (root == null) {
				height.h = 0;
				return 0;
			}
			int ldiameter = diameterOpt(root.left, lh);
			int rdiameter = diameterOpt(root.right, rh);

			height.h = Math.max(lh.h, rh.h) + 1;

			return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
		}

	    int diameter1(Node root)
	    {
	        Height height = new Height();
	        return diameterOpt(root, height);
	    }
	 
}
