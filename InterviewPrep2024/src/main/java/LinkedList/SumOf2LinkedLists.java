package LinkedList;

public class SumOf2LinkedLists {

	Node head1;
	Node head2;

	static Node addTwoLists(Node num1, Node num2) {

		Node a = reverse(num1);
		Node b = reverse(num2);
		Node root = null;

		int carry = 0;
		while (a != null || b != null || carry > 0) {
			int sum = 0;
			if (a != null)
				sum += a.data;
			if (b != null)
				sum += b.data;
			sum += carry;

			Node newNode = new Node(sum % 10);
			carry = sum / 10;

			newNode.next = root;
			root = newNode;

			if (a != null)
				a = a.next;

			if (b != null)
				b = b.next;

		}
		while (root.data == 0 &&  root.next != null) {
			root = root.next;
		}
		return root;
	}

	static Node reverse(Node node) {
		if (node == null)
			return node;
		Node prev = null;
		Node curr = node;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		SumOf2LinkedLists list = new SumOf2LinkedLists();

		// creating first list
		/*
		 * list.head1 = new Node(7); list.head1.next = new Node(5); list.head1.next.next
		 * = new Node(9); list.head1.next.next.next = new Node(4);
		 * list.head1.next.next.next.next = new Node(6);
		 * 
		 * // creating second list list.head2 = new Node(8); list.head2.next = new
		 * Node(4);
		 */

		list.head1 = new Node(0);
		list.head1.next = new Node(0);
		list.head1.next.next = new Node(0);
		list.head1.next.next.next = new Node(0);
		list.head1.next.next.next.next = new Node(0);

		// creating second list
		list.head2 = new Node(0);
		list.head2.next = new Node(0);
		System.out.print("Sum List: ");
		// add the two lists and see the result
		Node result = addTwoLists(list.head1, list.head2);
		Operation op = new Operation();
		op.printList(result);
	}

}
