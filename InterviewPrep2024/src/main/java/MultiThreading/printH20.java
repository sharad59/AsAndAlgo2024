package MultiThreading;

import java.util.concurrent.Semaphore;

public class printH20 {

	public static void main(String args[]) {

		Semaphore h = new Semaphore(2);
		Semaphore o = new Semaphore(0);

		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 4; i++) {

					try {
						h.acquire();
						System.out.print("h");
						if (h.availablePermits() == 0)
							o.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					try {
						o.acquire();
						System.out.print("o");
						System.out.println();
						h.release(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();
	}
}

class H2O {
    // private boolean o;
    private int h;

    public H2O() {
        this.h = 0;
        // this.o = false;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (this.h >= 2)
                wait();

            ++this.h;
            releaseHydrogen.run();
            notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (this.h < 2) {
                wait();
            }
            // this.o = true;
            this.h = 0;
            releaseOxygen.run();
            notifyAll();
        }
    }

}
