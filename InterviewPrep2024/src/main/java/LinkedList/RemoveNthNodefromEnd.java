package LinkedList;

public class RemoveNthNodefromEnd {

	 public static Node removeNthFromEnd(Node head, int n) {
	       int i=0;
	       Node first=head, prev= head;
	       Node h= head;
	       int s= size(head);
	       if(s==1){
	        return null;
	       }else if (s==n){
	        head=head.next;
	        return head;
	       }
	        while(i<n)
	        {
	            head=head.next;
	            i++;
	        }

	 while(head!=null){
	    head=head.next;
	      prev=first;
	    first=first.next;
	 }

	prev.next=first.next;
	first.next=null;

	return h;
	    }

	static int size (Node head){
	    int c=0;
	    while(head!=null){
	        head=head.next;
	        c++;
	    }
	    return c;
	}
}
