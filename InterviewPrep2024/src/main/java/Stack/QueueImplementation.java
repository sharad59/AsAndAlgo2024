package Stack;

import java.util.Stack;

public class QueueImplementation {

	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	static void enQueue(int x) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(x);

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	static int deQueue() {
		if (s1.isEmpty()) {
			return -1;
		}
		int x = s1.peek();
		s1.pop();
		return x;
	}

	public static void main(String[] args) {
		QueueImplementation q = new QueueImplementation();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

	public static void enQueue1(int x) {
		s1.push(x);

	}

	public static int deQueue1() {

		if (s1.isEmpty() && s2.isEmpty()) {
			return -1;
		}

		if (s2.isEmpty()) {

			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		int x = s2.pop();
		return x;
	}
}
