package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreHelloWorld {

	static Semaphore hello = new Semaphore(1);
	static Semaphore world = new Semaphore(0);

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		mt.hello = hello;
		mt.world = world;
		Thread2 t2 = new Thread2();
		t2.hello = hello;
		t2.world = world;
		t2.start();
		mt.start();

		/*
		 * for (int i = 0; i < 5; i++) { System.out.print(hello.availablePermits());
		 * hello.acquire(); // wait for it System.out.print("Hello");
		 * 
		 * world.release(); // go say world }
		 */
	}
}

class MyThread extends Thread {

	Semaphore hello, world;

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				
				world.acquire(); // wait-for it
				System.out.print(" World!");
				System.out.println();
                 Thread.sleep(500);
				hello.release(); // go say hello
				System.out.print("h "+hello.availablePermits()+ " ");

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread2 extends Thread {
	Semaphore hello, world;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				hello.acquire();
				System.out.print("hello");
				Thread.sleep(500);
				world.release();
				System.out.print("w "+world.availablePermits()+ " ");

			} catch (Exception e) {

			}
		}
	}
}
