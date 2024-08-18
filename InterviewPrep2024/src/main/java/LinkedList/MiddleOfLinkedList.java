package LinkedList;

public class MiddleOfLinkedList {

	static int getMiddle(Node head) {
		Node first = head;
		Node mid = head;
		int count = 1;
		while (first != null) {
			first = first.next;
			if (count % 2 == 0)
				mid = mid.next;
			count++;

		}
		return mid.data;
	}

	public static void main(String args[]) {

		Operation list = new Operation();
		list.insertAtFront(1);
		list.insertAtFront(2);
		list.insertAtFront(3);
		list.insertAtFront(4);
		list.insertAtFront(5);
		Node node =	list.insertAtFront(6);
		list.printList(node);
		int data = getMiddle(node);
		System.out.println(data);

	}
}
