package Queue;

public class QueueImplementation {

	private int front, rear, cap;
	private int queue[];

	public QueueImplementation( int cap) {
		this.front = 0;
		this.rear = 0;
		this.cap = cap;
		queue = new int[cap];

	}

	public void enqueue(int data) {
		if (rear == cap) {
			System.out.println("queue is overflow ");
			return;
		}else {
		queue[rear] = data;
		rear++;
		}
	}

	public int dequeue() {
		int deq = 0;
		if (rear == front) {
			System.out.println("queue is underflow");
			return -1;
		}
		deq = queue[front];

		for (int i = 0; i < rear - 1; i++) {
			queue[i] = queue[i + 1];
		}
		if (rear < cap) {
			queue[rear] = 0;
		}
		rear--;

		return deq;
	}

	public void printQueue() {
		if (rear == front) {
			System.out.println("queue is underflow");
		}
		for (int i = front; i < rear; i++) {
			System.out.println(queue[i]);
		}
	}

	public void displayFront() {

		if (rear == front) {
			System.out.println("queue is underflow");
		}

		System.out.println(queue[front]);
	}
	
	public static void main(String args[]) {
		QueueImplementation a = new QueueImplementation( 4);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		a.printQueue();

		
	}
}
