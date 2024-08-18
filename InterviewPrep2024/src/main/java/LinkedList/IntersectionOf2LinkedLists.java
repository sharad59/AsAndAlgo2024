package LinkedList;

public class IntersectionOf2LinkedLists {

	static int intersectPoint(Node head1, Node head2) {
		int c1 = size(head1);
		int c2 = size(head2);
		int res = 0;
		if (c1 > c2) {
			int d = c1 - c2;
			res = findIntersect(head1, head2, d);
		} else {
			int d = c2 -c1;
			res = findIntersect(head2, head1, d);
		}
		return res;
	}

	static int findIntersect(Node n1, Node n2, int d) {

		while (d > 0) {
			n1 = n1.next;
			d--;
		}

		while (n1 != null && n2 != null) {
			if (n1 == n2) {
				return n1.data;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return -1;
	}

	static int size(Node n1) {
		int c = 0;
		while (n1 != null) {
			c++;
			n1 = n1.next;
		}
		return c;
	}
	
	
	public static void main(String args[]) {

		Operation list = new Operation();
		list.insertAtFront(5);
		list.insertAtFront(4);
		list.insertAtFront(8);
		list.insertAtFront(1);
		Node node =	list.insertAtFront(4);
		
		Operation list2 = new Operation();
		list2.insertAtFront(5);
		list2.insertAtFront(4);
		list2.insertAtFront(8);
		list2.insertAtFront(1);
		list2.insertAtFront(6);
		Node node2 =	list2.insertAtFront(5);	
		list.printList(node);
		list.printList(node2);

		int data = intersectPoint(node, node2);
		System.out.println(data);

	}

}
