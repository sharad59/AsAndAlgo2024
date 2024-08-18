package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
	static class Stack {
		static Queue<Integer> q1 = new LinkedList<Integer>();// for pop
		static Queue<Integer> q2 = new LinkedList<Integer>(); // for push 

		static int curr_size;

		static void push(int x) {
			q2.add(x);

			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}

		static void pop() {
			if (q1.isEmpty())
				return;
			q1.remove();
		}

		static int top() {
			if (q1.isEmpty())
				return -1;
			return q1.peek();
		}

		static int size() {
			return q1.size();
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());
	}
	
	class Stack2 {
	    Queue<Integer> q1 = new LinkedList<Integer>();
	 
	    void push(int x)
	    {
	        int s = q1.size();
	 	        q1.add(x);
	        for (int i = 0; i < s; i++) {
	            q1.add(q1.remove());
	        }
	    }
	 
	    void pop()
	    {
	        if (q1.isEmpty())
	            return;
	        q1.remove();
	    }
	 
	    int top()
	    {
	        if (q1.isEmpty())
	            return -1;
	        return q1.peek();
	    }
}

}