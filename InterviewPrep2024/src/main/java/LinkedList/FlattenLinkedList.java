package LinkedList;

public class FlattenLinkedList {

	Node head;

	class Node {
		int data;
		Node next, bottom;

		Node(int data) {
			this.data = data;
			next = null;
			bottom = null;
		}
	}

	Node merge(Node a, Node b) {

		if (a == null)
			return b;

		if (b == null)
			return a;
		Node result;

		if (a.data < b.data) {
			result = a;
			result.bottom = merge(a.bottom, b);
		}

		else {
			result = b;
			result.bottom = merge(a, b.bottom);
		}

		result.next = null;
		return result;
	}

	Node flatten(Node root) {
		if (root == null || root.next == null)
			return root;
		root.next = flatten(root.next);
		root = merge(root, root.next);

		return root;
	}

	/*
	 */
	Node push(Node head_ref, int data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.bottom = head_ref;

		/* 4. Move the head to point to new Node */
		head_ref = new_node;

		/* 5. return to link it back */
		return head_ref;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.bottom;
		}
		System.out.println();
	}

	// Driver's code
	public static void main(String args[]) {
		FlattenLinkedList L = new FlattenLinkedList();

		/*
		 * Let us create the following linked list
		 *  5 -> 10 -> 19 -> 28
		 *   | | | | V V V V 
		 *   7   20    22     35 
		 *   8         50     40 
		 *   30               45
		 */

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.next = L.push(L.head.next, 20);
		L.head.next = L.push(L.head.next, 10);

		L.head.next.next = L.push(L.head.next.next, 50);
		L.head.next.next = L.push(L.head.next.next, 22);
		L.head.next.next = L.push(L.head.next.next, 19);

		L.head.next.next.next = L.push(L.head.next.next.next, 45);
		L.head.next.next.next = L.push(L.head.next.next.next, 40);
		L.head.next.next.next = L.push(L.head.next.next.next, 35);
		L.head.next.next.next = L.push(L.head.next.next.next, 28);

		L.head = L.flatten(L.head);

		L.printList();
	}
}
