package Btree;

class Res {
    public int val;
}
 
public class MaxPathSum {
	
	static int findMaxPathSum(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.key);
        return Math.max(leftMaxPath, rightMaxPath) + root.key;
    }

	 

	 
	static 	int findMaxSum(Node node) {
			int max[]= new int[1];
				findMaxPathSum(node, max);
				return max[0];
			 
		}
	    
	    public static void main(String args[])
	    {
	    	MaxPathSum tree = new MaxPathSum();
	        Node root = new Node(10);
	        root.left = new Node(2);
	        root.right = new Node(10);
	        root.left.left = new Node(20);
	        root.left.right = new Node(1);
	        root.right.right = new Node(-25);
	        root.right.right.left = new Node(3);
	        root.right.right.right = new Node(4);
	       // tree.findMaxSum(root);
	        System.out.println("maximum path sum is : "+findMaxSum(root)  );
	    }
}
