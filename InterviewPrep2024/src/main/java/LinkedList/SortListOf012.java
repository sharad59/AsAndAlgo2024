package LinkedList;

public class SortListOf012 {
	  static Node segregate(Node head)
	    {
	int arr[]={0,0,0};

	Node start=head;
	Node node=head;

	while (start!=null){
	    arr[start.data]++;
	    start=start.next;
	}
	int i=0;
	while (node!=null){
	    
	    if(arr[i]==0){
	        i++;
	    }
	    else{
	        
	        node.data=i;
	        arr[i]--;
	        node=node.next;
	    }
	}
	    return head;
	}

	public static Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node zeroD = new Node(0);
		Node oneD = new Node(0);
		Node twoD = new Node(0);

		Node zero = zeroD, one = oneD, two = twoD;
		Node curr = head;
		while (curr != null) {
			if (curr.data == 0) {
				zero.next = curr;
				zero = zero.next;
				curr = curr.next;
			} else if (curr.data == 1) {
				one.next = curr;
				one = one.next;
				curr = curr.next;
			} else {
				two.next = curr;
				two = two.next;
				curr = curr.next;
			}
		}
		zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next);
		one.next = twoD.next;
		two.next = null;
		head = zeroD.next;
		return head;
	}
}
