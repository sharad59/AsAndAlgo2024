package MultiThreading;

class Sender {

	public void send(String msg) {
		synchronized (this) {

			System.out.println("sending " + msg);
			System.out.println(msg + "  sent");
		}
	}
}

class NewThread extends Thread {
	Sender s;
	String msg;

	NewThread(Sender s, String msg) {
		this.s = s;
		this.msg = msg;
	}

	public void run() {
		System.out.println(this.getName());
		s.send(msg);
	}

}

public class SyncronizedBlockExample {

	public static void main(String args[]) throws InterruptedException {

		Sender s1 = new Sender();
		NewThread n1 = new NewThread(s1, "Hi");
		NewThread n2 = new NewThread(s1, "Bye");
		n1.start();
		n2.start();
		//n1.join();
		//n2.join();

		/*
		 * Thread t1 = new Thread() { public void run() { s1.send("Hello Testing"); } };
		 * t1.start();
		 */
	}
}
