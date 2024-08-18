package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemphoreOddEvenZero {

	private int n;
	Semaphore z = new Semaphore(1);
	Semaphore o = new Semaphore(0);
	Semaphore e = new Semaphore(0);

	public SemphoreOddEvenZero(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero() throws InterruptedException {

		for (int i = 1; i <= n; i++) {
			z.acquire();
			System.out.print(0);
			if (i % 2 == 0)
				e.release();
			else
				o.release();
		}

	}

	public void even() throws InterruptedException {

		for (int i = 2; i <= n; i+=2) {
			e.acquire();
			System.out.print(i);
			z.release();

		}
	}

	public void odd() throws InterruptedException {
		for (int i = 1; i <= n; i+=2) {
			o.acquire();
			System.out.print(i);
			z.release();
		}
	}

	public static void main(String args[]) {
		SemphoreOddEvenZero z = new SemphoreOddEvenZero(5);

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

class ZeroEvenOdd {
    private int n;
    // private volatile int currState; no need to use volatile if using sync block
    private int currState;
    private final int ZERO, EVEN, ODD;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.ZERO = 0;
        this.EVEN = 2;
        this.ODD = 1;
        this.currState = ZERO;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                while (currState != ZERO)
                    wait();

    			System.out.print(0);
                if (i %2 == 1) {
                    currState = ODD;
                } else {
                    currState = EVEN;
                }

                notifyAll();
            }
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (currState != EVEN)
                    wait();

    			System.out.print(i);
                currState = ZERO;
                notifyAll();
            }
        }
    }

    public void odd( ) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (currState != ODD)
                    wait();
    			System.out.print(i);
                currState = ZERO;
                notifyAll();
            }
        }
    }
}
