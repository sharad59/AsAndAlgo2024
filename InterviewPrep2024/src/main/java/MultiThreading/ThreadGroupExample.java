package MultiThreading;

public class ThreadGroupExample extends Thread {

	public ThreadGroupExample(ThreadGroup threadGroup, String tname) {
		super( threadGroup,tname);
	}

	@Override
	public void run() {

		try {
			Thread.sleep(300);
			System.out.println(Thread.currentThread().getThreadGroup().getName());
			System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
			System.out.println(Thread.currentThread().getThreadGroup().isDestroyed());

		} catch (InterruptedException e) {
			System.out.println("Exception occured");
		}
	}

	public static void main(String args[]) {
		ThreadGroup grp= new ThreadGroup("parentGp1");
		ThreadGroupExample t= new ThreadGroupExample(grp, "child");
		System.out.println("grp name  "+grp.getName());
		System.out.println("grp parent name  "+grp.getParent().getName());
		t.start();
		
	}
}
