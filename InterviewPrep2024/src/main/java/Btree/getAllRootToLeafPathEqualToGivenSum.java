package Btree;

import java.util.ArrayList;
import java.util.List;

import Btree.LevelOrderWithDirectionChange.Node;

public class getAllRootToLeafPathEqualToGivenSum {

	public List<List<Integer>> pathSum(Node root, int targetSum) {

		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> output = new ArrayList<>();

		getAllPathSums(root, temp, output, targetSum);
		return output;
	}

	public void getAllPathSums(Node root, List<Integer> temp, List<List<Integer>> output, int sum) {
		if (root == null)
			return;

		temp.add(root.data);
		if (root.left == null && root.right == null && root.data == sum)
			output.add(temp);
		else

		{
			getAllPathSums(root.left, new ArrayList<>(temp), output, sum - root.data);
			getAllPathSums(root.right, new ArrayList<>(temp), output, sum - root.data);

		}

	}

	
	 public static List<List<Integer>> pathSum2(Node root, int targetSum) {
	        List<List<Integer>>ans=new ArrayList<List<Integer>>();
	        List<Integer>temp=new ArrayList<Integer>();
	        helper(root,targetSum,ans,temp);
	        return ans;
	        
	    }

	    public static void helper(Node root, int targetSum,List<List<Integer>>ans,List<Integer>temp){
	        if(root==null){
	            return;
	        }

	        temp.add(root.data);

	        if(root.left==null&&root.right==null&&root.data==targetSum){
	            ans.add(new ArrayList<Integer>(temp));
	        }

	        helper(root.left,targetSum-root.data,ans,temp);
	        helper(root.right,targetSum-root.data,ans,temp);

	        temp.remove(temp.size()-1);
	        //targetSum+=root.data;
	    }
	    

		static Node newNode(int data) {
			Node temp = new Node();
			temp.data = data;
			temp.left = temp.right = null;
			return temp;
		}

		public static void main(String[] args) {
			Node root = newNode(1);
			root.left = newNode(2);
			root.right = newNode(0);
			root.left.left = newNode(4);
			root.left.right = newNode(5);
			root.right.left = newNode(6);
			root.right.right = newNode(7);
			
		List<List<Integer>> s=	pathSum2(root, 8);
		System.out.println(s);
		}
}
