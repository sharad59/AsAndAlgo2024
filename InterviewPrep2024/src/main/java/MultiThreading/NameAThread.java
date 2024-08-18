package MultiThreading;

public class NameAThread extends Thread {

	public NameAThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				//Thread.currentThread().setName("def");
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName());
				System.out.println("isDaemon"+Thread.currentThread().isDaemon());
				System.out.println("Is Alive"+Thread.currentThread().isAlive());
				System.out.println("Is Interuppted"+Thread.currentThread().isInterrupted());


			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]) {

		NameAThread t1 = new NameAThread("abc");
		t1.setDaemon(true);
		t1.start();
		NameAThread t2 = new NameAThread("def");
t2.start();
		//t1.setDaemon(true);

	}
}
