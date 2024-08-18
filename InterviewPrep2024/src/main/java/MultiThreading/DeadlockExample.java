package MultiThreading;

public class DeadlockExample {
	static class Resource {
        private final String name;

        Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private final Resource resource1 = new Resource("Resource1");
    private final Resource resource2 = new Resource("Resource2");

    public void method1() {
        synchronized (resource1) {
            System.out.println("Thread 1: Locked " + resource1.getName());

            //try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (resource2) {
                System.out.println("Thread 1: Locked " + resource2.getName());
            }
        }
    }

    public void method2() {
        synchronized (resource2) {
            System.out.println("Thread 2: Locked " + resource2.getName());

            //try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (resource1) {
                System.out.println("Thread 2: Locked " + resource1.getName());
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample deadlock = new DeadlockExample();

        Thread thread1 = new  Thread(deadlock::method1);
        Thread thread2 = new Thread(deadlock::method2);

        thread1.start();
        thread2.start();
    }
}
