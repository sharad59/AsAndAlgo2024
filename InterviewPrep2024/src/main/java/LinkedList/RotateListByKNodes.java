package LinkedList;

public class RotateListByKNodes {

	public static Node rotate(Node head, int k) {
		Node start = head;
		int count = 1;
		while (count < k) {
			head = head.next;
			count++;
		}
		Node newHead = head.next;
		head.next = null;
		head = newHead;
		if (newHead == null)
			return start;
		while (head.next != null)
			head = head.next;

		head.next = start;
		return newHead;
	}

	static Node rotate(int k, Node head) {
		Node last = head;
		Node temp = head;

		if (head == null || k == 0) {
			return head;
		}

		while (last.next != null) {
			last = last.next;
		}
		while (k != 0) {

			head = head.next;
			temp.next = null;
			last.next = temp;
			last = temp;
			temp = head;
			k--;
		}
		return head;
	}

	public static void main(String args[]) {

		Operation list = new Operation();
		list.insertAtFront(5);
		list.insertAtFront(4);
		list.insertAtFront(3);
		list.insertAtFront(2);
		Node node = list.insertAtFront(1);
		list.printList(node);
		Node de = rotate(2,node);
		list.printList(de);

	}
}
