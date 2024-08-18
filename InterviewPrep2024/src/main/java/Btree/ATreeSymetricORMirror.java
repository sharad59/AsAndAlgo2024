package Btree;

import java.util.Stack;

public class ATreeSymetricORMirror {

	static boolean isSymetric(Node node) {

		Stack<Node> st1 = new Stack<Node>();

		st1.push(node.left);
		st1.push(node.right);

		while (!st1.isEmpty()) {
			Node t1 = st1.pop();
			Node t2 = st1.pop();

			if (t1 == null && t2 == null)
				continue;

			if (t1 == null || t2 == null)
				return false;
			if (t1.key != t2.key)
				return false;
			st1.push(t1.left);
			st1.push(t2.right);
			st1.push(t1.right);
			st1.push(t2.left);
		}
		return true;

	}

	boolean isMirror(Node node1, Node node2)
	    {
	        if (node1 == null && node2 == null)
	            return true;

	      
	        if (node1 == null || node2 == null)
	        	return false;
	        
			else
				return   node1.key == node2.key
						&& (isMirror(node1.left, node2.right)
						&& isMirror(node1.right, node2.left));

	     
	    }

	boolean isSymmetric(Node root) {
		return isMirror(root, root);
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		if (isSymetric(root))
			System.out.println("Symmetric");
		else
			System.out.println("Not symmetric");
	}
}