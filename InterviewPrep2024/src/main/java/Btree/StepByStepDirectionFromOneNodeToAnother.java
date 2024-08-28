package Btree;

public class StepByStepDirectionFromOneNodeToAnother {
//first find LCS as path passes through lcs then startValue to LCS is All U then LCS to destValue is path
  
	public String getDirections(Node root, int startValue, int destValue) {
   
    	Node lcs= findLeastCommonAncestor(root,startValue,destValue);
    	
    	StringBuilder st=new StringBuilder();
    	StringBuilder dt=new StringBuilder();
    	findPath(st,lcs, startValue);
    	findPath(dt,lcs, destValue);

        StringBuilder directions = new StringBuilder();
        directions.append("U".repeat(st.length()));
        directions.append(dt);
        return directions.toString();
        
    	
    
    }
	
	private boolean findPath(StringBuilder st, Node root, int target) {
		if (root == null)
			return false;

		if (root.key == target)
			return true;
		st.append("L");
		if (findPath(st, root.left, target))
			return true;
		st.setLength(st.length() - 1);

		st.append("R");
		if (findPath(st, root.right, target))
			return true;
		st.setLength(st.length() - 1);
		return false;

	}

	private Node findLeastCommonAncestor(Node root, int s, int d) {

		if (root == null)
			return null;
		if (root.key == s || root.key == d) {
			return root;
		}
		Node left = findLeastCommonAncestor(root.left, s, d);
		Node right = findLeastCommonAncestor(root.right, s, d);
		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;

	}

	Node root;

	public static void main(String args[]) {

		StepByStepDirectionFromOneNodeToAnother tree = new StepByStepDirectionFromOneNodeToAnother();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		System.out.println(tree.getDirections(tree.root, 4, 8));
	}
}
