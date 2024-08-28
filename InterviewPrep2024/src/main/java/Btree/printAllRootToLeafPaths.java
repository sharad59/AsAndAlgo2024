package Btree;

import java.util.ArrayList;
import java.util.List;

public class printAllRootToLeafPaths {

    Node root;
	public void printRootToLeaf(Node root) {
		
	List<String> temp= new ArrayList<>();	
	List<String> output= new ArrayList<>();	
	
		printPath(root,temp,output);
		
		System.out.println(output);
	}
	
	private void printPath(Node root, List<String> temp, List<String> output) {

		if (root == null)
			return;
		temp.add(String.valueOf(root.key));

		if (root.left == null && root.right == null) {
			output.add(String.join("->", temp));
		}
		else {
		printPath(root.left,  new ArrayList<String>(temp), output);
		printPath(root.right, new ArrayList<String>(temp), output);
		}

	}

	public static void main(String args[]) {

		printAllRootToLeafPaths tree = new printAllRootToLeafPaths();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.printRootToLeaf(tree.root);

	}
}
