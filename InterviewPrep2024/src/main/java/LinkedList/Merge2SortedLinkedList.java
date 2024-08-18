package LinkedList;

public class Merge2SortedLinkedList {
	static Node sortedMerge(Node head1, Node head2) {

		Node d = new Node(0);
		Node tail = d;

		while (true) {

			if (head1 == null) {
				d.next = head2;
				break;
			}

			if (head2 == null) {
				d.next = head1;
				break;
			}

			if (head1.data < head2.data) {
				d.next = head1;
				head1 = head1.next;
				d = d.next;

			}

			if (head2.data < head1.data) {
				d.next = head2;
				head2 = head2.next;
				d = d.next;

			}

		}

		return tail.next;
	}
	
	 public static Node sortedMerge1(Node A, Node B)
	    {
	 
	        if (A == null)
	            return B;
	        if (B == null)
	            return A;
	 
	        if (A.data < B.data) {
	            A.next = sortedMerge1(A.next, B);
	            return A;
	        }
	        else {
	            B.next = sortedMerge1(A, B.next);
	            return B;
	        }
	    }

	public static void main(String args[]) {

		Operation list = new Operation();

		list.insertAtFront(7);
		list.insertAtFront(4);
		Node node = list.insertAtFront(2);
		list.printList(node);

		Operation list2 = new Operation();
		list2.insertAtFront(5);
		list2.insertAtFront(3);
		Node node2 = list2.insertAtFront(1);
		list.printList(node2);

		Node a = sortedMerge1(node, node2);
		list.printList(a);

	}
}
