package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	 void levelOrder(Node node) {
		Height ht= new Height();
		int h= ht.height(node);
		for(int i =1;i<=h;i++) {
			printCurrentLevel(i, node);
			System.out.println(" ");

		}
		
	}

	 void printCurrentLevel(int l, Node node) {
		 if(node==null)
			 return ;
		if(l==1) {
			System.out.print(node.key+" ");
		}
		else if(l>1) {
			printCurrentLevel(l-1, node.left);
			printCurrentLevel(l-1, node.right);
		}
	}
	 
	void queueTraversal(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		while (!q.isEmpty()) {

			Node t = q.poll();

			if (t == null) {
				System.out.println("");
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				System.out.print(t.key+ " ");
			}
			
			if (t != null) {
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}  
		}
	}
	
	 public static void main(String args[])
	    {
		 LevelOrderTraversal tree = new LevelOrderTraversal();
	      Node root= new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	 
	        System.out.println("Level order traversal of"
	                           + "binary tree is ");
	   tree.queueTraversal(root);
}
}