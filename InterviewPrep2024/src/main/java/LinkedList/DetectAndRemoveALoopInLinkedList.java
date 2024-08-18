package LinkedList;

import java.util.HashSet;

public class DetectAndRemoveALoopInLinkedList {

	public static boolean removeLoop(Node node) {
		HashSet<Node> set = new HashSet<>();
		Node prev = null;

		while (node != null) {
			if (set.contains(node)) {
				prev.next = null;
				return true;
			} else {
				prev = node;
				set.add(node);
				node = node.next;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Operation list = new Operation();

		Node head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);

		head.next.next.next.next.next = head.next.next;

		if (removeLoop(head)) {
			System.out.println("Linked List after removing loop");
			list.printList(head);
		} else
			System.out.println("No Loop found");
	}
}
