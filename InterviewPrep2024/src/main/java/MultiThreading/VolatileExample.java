package MultiThreading;

	public class VolatileExample extends Thread {
	    private volatile boolean running = true;

	    public void run() {
	        while (running) {
	            System.out.println("Running");
	            if(!running)
		            System.out.println("now false");

	        }
	    }

	    public void stopRunning() {
	        running = false;
	    }
	

	    public static void main(String[] args) throws InterruptedException {
	        VolatileExample example = new VolatileExample();
	        example.start();

	        // Sleep for 1 second
	        Thread.sleep(1000);

	        example.stopRunning();
	    }
	}

