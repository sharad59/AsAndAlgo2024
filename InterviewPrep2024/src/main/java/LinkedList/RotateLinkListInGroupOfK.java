package LinkedList;

public class RotateLinkListInGroupOfK {

	static Node reverse(Node head, int k) {
		if (head == null)
			return null;
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
			head.next = reverse(next, k);
		return prev;
	}

	public static void main(String args[]) {

		Operation list = new Operation();
		list.insertAtFront(5);
		list.insertAtFront(4);
		list.insertAtFront(3);
		list.insertAtFront(2);
		Node node = list.insertAtFront(1);
		list.printList(node);
		Node de = reverseKGroup(node, 3);
		list.printList(de);

	}

	static int size(Node head) {
		int c = 0;
		while (head != null) {
			head = head.next;
			c++;
		}
		return c;
	}

	public static Node reverseKGroup(Node head, int k) {
		int s = size(head);
		Node node = reverse1(head, k, s);
		return node;

	}

	static Node reverse1(Node head, int k, int s) {
		Node curr = null, prev = null, next = null;
		curr = head;
		int count = 0;
		if (k>s && s % k != 0)
			return head;
		while (count < k && curr != null) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null) {
			head.next = reverse1(next, k, s - k);
		}
		return prev;

	}
}
