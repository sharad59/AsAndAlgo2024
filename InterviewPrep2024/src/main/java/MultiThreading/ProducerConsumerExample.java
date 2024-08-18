package MultiThreading;

import java.util.LinkedList;

public class ProducerConsumerExample {
	static int val=0;
	int cap = 2;
	LinkedList<Integer> l = new LinkedList<Integer>();

	public void produce() throws InterruptedException {
		while (val<5) {

			synchronized (this) {
				while (l.size() == 1)
					this.wait();
				System.out.println("producer produces value " + val);
				l.add(val++);
				this.notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while (val<5) {

			synchronized (this) {
				while (l.size() == 0)
					this.wait();
				int val = l.removeFirst();
				System.out.println("Consumer consumed " + val);
				this.notify();
				Thread.sleep(1000);

			}
		}
	}

	public static void main(String args[]) {
		ProducerConsumerExample pc = new ProducerConsumerExample();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					System.out.println("Exception occured");
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					System.out.println("Exception occured");
				}
			}
		};
		t1.start();
		t2.start();
	}
}
