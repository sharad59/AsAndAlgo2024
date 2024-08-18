package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertToMirrorTree {
//convert a tree to its mirroe tree 
	static void convert(Node node) {
		if(node==null)
			return;
		
		
		convert(node.left);
		convert(node.right);
		
		Node temp =node.left;
		node.left=node.right;
		node.right=temp;
	}

	public static void main (String args[]) {
		
        Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
        root.left.left = new Node(4);
       root.left.right = new Node(5);
 
        System.out.println(
            "Inorder traversal of the constructed tree is");
        InOrderTraversal a =new InOrderTraversal();

        a.print(root);
        System.out.println("");

        convert(root);
 
        System.out.println(
            "Inorder traversal of the mirror tree is");
       a.print(root);
	}
	
	 static void mirror(Node root)
	    {
	        if (root == null)
	            return;
	 
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);

	        while (q.size() > 0) {
	            Node curr = q.peek();
	            q.remove();
	 
	            Node temp = curr.left;
	            curr.left = curr.right;
	            curr.right = temp;
	 
	            // push left and right children
	            if (curr.left != null)
	                q.add(curr.left);
	            if (curr.right != null)
	                q.add(curr.right);
	        }
	    }
}
