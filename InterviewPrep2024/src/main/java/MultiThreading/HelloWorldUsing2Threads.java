package MultiThreading;

public class HelloWorldUsing2Threads {
	static int c = 0;
	static boolean flag = false;

	public void hello() throws InterruptedException {
		while (c < 5) {

			synchronized (this) {
				while (flag)
					wait();
				System.out.print("Hello ");
				c++;
				flag = true;

				notify();

				 Thread.sleep(1000);
			}
		}

	}

	public void world() throws InterruptedException {
		while (c < 5) {
			synchronized (this) {
				while (flag == false)
					wait();
				System.out.print("world");
				flag = false;
				notify();
				System.out.println();
				//Thread.sleep(1000);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		HelloWorldUsing2Threads w = new HelloWorldUsing2Threads();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					w.hello();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					w.world();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
	}
}
