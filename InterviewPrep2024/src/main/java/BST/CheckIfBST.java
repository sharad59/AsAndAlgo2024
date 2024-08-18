package BST;

import Btree.Node;

public class CheckIfBST {

	
	 boolean isBST()
	    {
		 Node root=null; 
	        return isBSTUtil(root, Integer.MIN_VALUE,
	                         Integer.MAX_VALUE);
	    }

	
	    boolean isBSTUtil(Node node, int min, int max)
	    {
	        if (node == null)
	            return true;

	        if (node.key < min || node.key > max)
	            return false;

	        return (
	            isBSTUtil(node.left, min, node.key - 1)
	            && isBSTUtil(node.right, node.key + 1, max));
	    }
	    
		static Node prev;

		static Boolean isBSTUtil(Node root) {

			if (root == null)
				return true;

			if (!isBSTUtil(root.left))
				return false;

			if (prev != null && root.key <= prev.key)
				return false;

			prev = root;

			return isBSTUtil(root.right);

		}

    static Boolean isBST(Node root)
    {
        return isBSTUtil(root);
    }
}
