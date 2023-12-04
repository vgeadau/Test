/**
 * Deadlock example.
 * -----------------------------------------------------------------------------------
 * What the code does?
 * -----------------------------------------------------------------------------------
 * This example creates 2 threads each trying to access one resource and the other.
 * T1 locks R1, waits for 100 ms then tries to lock R2
 * T2 locks R2, waits for 100 ms then tries to lock R1
 * -----------------------------------------------------------------------------------
 * What is happening?
 * -----------------------------------------------------------------------------------
 * Both T1 and T2 manage to lock their first resource (R1 for T1 and R2 for T2) however,
 * the threads will wait for each other to release their initial locks in order to lock their second resources
 * (R2 for T1 and R1 for T2) but that never happens and as result we have the deadlock.
 *
 * @author Valentin
 *
 */
public class DeadlockExample {
    /**
     * the first resource used for deadlock simulation
     */
    private static final Object resource1 = new Object();

    /**
     * the second resource used for deadlock simulation
     */
    private static final Object resource2 = new Object();

    /**
     * main method.
     * @param args String array
     */
    public static void main(String[] args) {

        // we create thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding resource 1");

                try {
                    Thread.sleep(100); // Simulating some work
                } catch (InterruptedException e) {
                    // handle error if needed
                }

                System.out.println("Thread 1: Waiting for resource 2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding resource 1 and resource 2");
                }
            }
        });

        // we create thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding resource 2");

                try {
                    Thread.sleep(100); // Simulating some work
                } catch (InterruptedException e) {
                    // handle error if needed
                }

                System.out.println("Thread 2: Waiting for resource 1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Holding resource 1 and resource 2");
                }
            }
        });

        // we start the threads
        thread1.start();
        thread2.start();
    }
}