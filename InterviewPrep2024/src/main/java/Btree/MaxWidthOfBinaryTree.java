package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

	int getMaxWidth(Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		int i;

		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}
		return maxWidth;
	}

	int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}

	int height(Node node) {
		if (node == null)
			return 0;
		else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
		}
	}
	
	static int maxwidth(Node root)
    {
        if (root == null)
            return 0;
        int maxwidth = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) 
        {

            int count = q.size();
            maxwidth = Math.max(maxwidth, count);

            for (int i=0;i<count;i++) {
                Node temp = q.remove();
                if (temp.left != null)
                {
                    q.add(temp.left);
                }
                if (temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;
    }
	
	 public static void main(String[] args)
	    {
			Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
			root.right.right = new Node(8);
			root.right.right.left = new Node(6);
			root.right.right.right = new Node(7);

	        /*   Constructed Binary tree is:
	        1
	      /   \
	    2      3
	  /  \      \
	 4    5      8
	           /   \
	          6     7    */

	        // Function call
	        System.out.println("Maximum width = "
	                           + maxwidth(root));
	    }
}
