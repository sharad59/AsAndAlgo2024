package LinkedList;

public class Node {

	Node next;
	int data;

	Node(int item) {
		this.data = item;
	}

	Node() {
	}
}

class Operation {

	Node head;

	public Node insertAtFront(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
		return node;

	}

	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;

		}
		System.out.println(" ");

	}
}
