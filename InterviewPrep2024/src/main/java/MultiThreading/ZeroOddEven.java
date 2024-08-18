package MultiThreading;

public class ZeroOddEven {

	private int n;
	private int i = 0;
	boolean oddeven = false;

	public ZeroOddEven(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero() throws InterruptedException {
		while (i < n) {
			synchronized (this) {
				while (oddeven == true) {
					this.wait();
				}
				System.out.print(0);
				if (i == 0)
					i++;
				oddeven = true;
				this.notifyAll();
			}
		}
	}

	public void even() throws InterruptedException {

		while (i < n) {
			synchronized (this) {

				while (i % 2 != 0 || oddeven == false)
					this.wait();
				if (i > n)
					return;
				System.out.print(i);
				i++;
				oddeven = false;
				this.notifyAll();
			}
		}

	}

	public void odd() throws InterruptedException {

		while (i < n) {
			synchronized (this) {
				while (i % 2 == 0 || oddeven == false)
					this.wait();
				if (i > n)
					return;
				System.out.print(i);
				if (i < n) {
					oddeven = false;
				}
				i++;
				this.notifyAll();
			}
		}
	}

	public static void main(String args[]) {

		ZeroOddEven z = new ZeroOddEven(10);

		Thread t1 = new Thread() {
			@Override
			public void run() {

				try {
					z.zero();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {

				try {
					z.even();
					;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t3 = new Thread() {
			@Override
			public void run() {

				try {
					z.odd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();
	}
}
