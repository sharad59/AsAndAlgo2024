package LinkedList;

import java.util.Stack;

public class CheckIFLinkedListPalindrome {
	Node head;
	Node left;

	boolean isPalindrome(Node head) {

		Stack<Node> st = new Stack<Node>();
		Node start = head;
		while (start != null) {
			st.push(start);
			start = start.next;
		}

		while (head != null) {
			Node t = st.pop();
			if (head.data != t.data) {
				return false;
			}
			head = head.next;

		}
		return true;
	}

	boolean isPalindromeUtil(Node right) {
		left = head;
		if (right == null)
			return true;
		boolean isp = isPalindromeUtil(right.next);
		if (isp == false)
			return false;
		 isp = (right.data == left.data);
		left = left.next;
		return isp;
	}
	
	 public boolean isPalindrome1(Node right ) {
	         left=right;
	     return isPalindrome2(right ) ;
	      }

	 

	      public boolean isPalindrome2(Node right ) {
	        if(right==null){
	            return true;
	        }

	        boolean isp= isPalindrome2(right.next);
	        if(isp==false){
	            return false;
	        }
	        isp=(right.data==left.data);
	        left=left.next;
	        return isp;
	}

	public static void main(String args[]) {
		CheckIFLinkedListPalindrome a = new CheckIFLinkedListPalindrome();
		Operation list = new Operation();
		//list.insertAtFront(1);
		list.insertAtFront(1);
		list.insertAtFront(2);
		list.insertAtFront(2);
		Node node = list.insertAtFront(1);
		a.head = node;
		list.printList(node);
		boolean de = a.isPalindrome1(node);
		System.out.println(de);
	}
}
