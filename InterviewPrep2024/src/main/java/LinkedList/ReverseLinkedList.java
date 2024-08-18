package LinkedList;

public class ReverseLinkedList {

	 static  Node reverseList(Node head)
	    {
	Node curr=head;
	Node next=null,prev=null;

	while(curr!=null){
	    next=curr.next;
	    curr.next=prev;
	    prev=curr;
	    curr=next;
	    
	}
	return prev;
	    }
	  
	  public static void main(String args[]) {

			Operation list = new Operation();
			list.insertAtFront(6);
			list.insertAtFront(5);
			list.insertAtFront(4);
			list.insertAtFront(3);
			list.insertAtFront(2);
			Node node =	list.insertAtFront(1);
			list.printList(node);
			 Node l = reverseList(node);
			list.printList(l);

		}
}
