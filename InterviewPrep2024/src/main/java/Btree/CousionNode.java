package Btree;

public class CousionNode {

	public boolean isSiblings(Node node,Node a, Node b) {
		if(node==null)
			return false;
		
		if(node.left==a && node.right==b||node.right==a&&node.left==b)
		return true;
		
		isSiblings(node.left, a, b);
		isSiblings(node.right, a, b);

		return false;
	}
	
	
	void checkCousions(Node node,Node a ,Node b) {
		
		Height h=new Height();
		int h1=h.height(a);
		int h2=h.height(b);
		if(h1==h2 && !isSiblings(node, a, b)) {
			System.out.println("cousions");
		}
		else {
			System.out.println("not cousions");
		}
	}
	
	 public static void main(String args[])
	    {
		 CousionNode tree = new CousionNode();
	        Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.left.right.right = new Node(15);
	        root.right.left = new Node(6);
	        root.right.right = new Node(7);
	        root.right.left.right = new Node(8);
	 
	        Node Node1, Node2;
	        Node1 =  root.left.right.right ;
	        Node2 = root.right.left.right;
	        tree.checkCousions(root, Node1, Node2);
	    }
}
