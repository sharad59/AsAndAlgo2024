package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	class Counter {
		static int c = 0;
		public void count() {
			 int j = c + 5;
			for (; c < j; c++) {
				System.out.println("ThreadName " + Thread.currentThread().getName() + " " + c);
			}
		}
	}

	class Thread1 extends Thread {
		Semaphore sm;
		String name;
		Counter c;

		Thread1(Semaphore sm, String name, Counter c) {
			super(name);
			this.sm = sm;
			this.name = name;
			this.c = c;

		}

		@Override
		public void run() {
			try {
				sm.acquire();
				System.out.println(name + " got a permit");
				c.count();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(name + " releasing permit");
			sm.release();
		}
	}

	public static void main(String args[]) {
		SemaphoreExample se = new SemaphoreExample();

		Counter c = se.new Counter();
		Semaphore sm = new Semaphore(1);
		Thread1 t1 = se.new Thread1(sm, "thread1", c);
		Thread1 t2 = se.new Thread1(sm, "thread2", c);

		t1.start();
		System.out.println(c.c);
		t2.start();
	}
}
