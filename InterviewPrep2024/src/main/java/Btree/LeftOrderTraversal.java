package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftOrderTraversal {

	static int max_level = Integer.MIN_VALUE;

	void printLeftOrder(Node node, int level) {

		if (node == null)
			return;

		if (level > max_level) {
			System.out.println(node.key);
			 max_level=level;
		}
		printLeftOrder(node.left, level + 1);
		printLeftOrder(node.right, level + 1);

	}
	
	void printBFSLeftOrder(Node node) {
		
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()) {
			int s=q.size();
			for(int i=0;i<s;i++) {
				Node t=q.poll();
				if(i==0)
				System.out.println(t.key);
				
				if(t.left!=null)
					q.add(t.left);
				if(t.right!=null)
					q.add(t.right);
			}
			
		}
	}

	public static void main(String args[]) {
		LeftOrderTraversal l = new LeftOrderTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.left = new Node(7);
		l.printBFSLeftOrder(root);

	}
}