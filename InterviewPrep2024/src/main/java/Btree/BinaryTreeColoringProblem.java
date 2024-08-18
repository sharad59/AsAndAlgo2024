package Btree;

public class BinaryTreeColoringProblem {
	TreeNode root;

	 int left, right, val;

	    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
	        val = x;
	        count(root);
	        int parentNodeCount = n - left - right - 1;
	        int nodestoChosse = Math.max(Math.max(left, right), parentNodeCount);
	        return nodestoChosse > n / 2;
	    }

	    private int count(TreeNode node) {
	        if (node == null)
	            return 0;
	        int l = count(node.left);
	        int r = count(node.right);
	        if (node.val == val) {
	            left = l;
	            right = r;
	        }
	        return l + r + 1;
	    }
	    
	    
	    public static void main(String args[]) {
	    	BinaryTreeColoringProblem tree =new BinaryTreeColoringProblem();	
	    	tree.root = new TreeNode(1);
			tree.root.left = new TreeNode(2);
			
			tree.root.right = new TreeNode(3);
			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);
			
			tree.root.left.left = new TreeNode(4);
			tree.root.left.left.left = new TreeNode(8);
			tree.root.left.left.right = new TreeNode(9);

			tree.root.left.right = new TreeNode(5);
			tree.root.left.right.left = new TreeNode(10);
			tree.root.left.right.right = new TreeNode(11);

			tree.root.right.left = new TreeNode(6);
			tree.root.right.right = new TreeNode(7);

			System.out.println(tree.btreeGameWinningMove(tree.root, 11, 3));

	    	
	    	
	    }
	    
	    
	    
}
