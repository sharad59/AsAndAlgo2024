 package Btree;

import java.util.Stack;

public class CheckMirrorTree {





	static boolean areMirror(Node a, Node b) 
	{
		if (a == null && b == null)
			return true;

		if (a == null || b == null) 
			return false;

		return a.key == b.key
				&& areMirror(a.left, b.right)
				&& areMirror(a.right, b.left);
	}
	
	
	static boolean isMirrorIterative(Node root1, Node root2) {
		if (root1 == null && root2 == null)
		return true;
		      if (root1 == null || root2 == null)
		        return false;
		 
		    Stack<Node> s1 = new Stack<>();
		    Stack<Node> s2 = new Stack<>();
		    s1.push(root1);
		    s2.push(root2);
		 
		    while (!s1.empty() && !s2.empty()) {
		        Node curr1 = s1.pop();
		        Node curr2 = s2.pop();
		 
		        if (curr1.key != curr2.key)
		            return false;
		 
		        if (curr1.left != null && curr2.right != null) {
		            s1.push(curr1.left);
		            s2.push(curr2.right);
		        } else if (curr1.left != null || curr2.right != null)
		            return false;
		 
		        if (curr1.right != null && curr2.left != null) {
		            s1.push(curr1.right);
		            s2.push(curr2.left);
		        } else if (curr1.right != null || curr2.left != null)
		            return false;
		    }
		 
		    if (!s1.empty() || !s2.empty())
		        return false;
		 
		    return true;
		}

	public static void main(String[] args) 
	{
		Node a = new Node(1);
		Node b = new Node(1);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);

		b.left = new Node(3);
		b.right = new Node(2);
		b.right.left = new Node(5);
		b.right.right = new Node(4);

		if (areMirror(a, b) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}

