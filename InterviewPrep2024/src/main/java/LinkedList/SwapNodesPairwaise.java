package LinkedList;

public class SwapNodesPairwaise {
	Node head;

	Node pairWiseSwap(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node prev = node;
		Node curr = node.next;

		node = curr;

		while (true) {
			Node next = curr.next;
			curr.next = prev;

			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			curr = prev.next;
		}
		return node;
	}
	
	Node pairWiseSwap1(Node node) {

		if (node == null || node.next == null) {
			return node;
		}
		Node remaining = node.next.next;
		Node newhead = node.next;
		node.next.next = node;

		node.next = pairWiseSwap(remaining);
		return newhead;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5->6->7
		 */
		SwapNodesPairwaise list = new SwapNodesPairwaise();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);

		System.out.println("Linked list before calling pairwiseSwap() ");
		list.printList(list.head);
		Node st = list.pairWiseSwap(list.head);
		System.out.println("");
		System.out.println("Linked list after calling pairwiseSwap() ");
		list.printList(st);
		System.out.println("");
	}
}
