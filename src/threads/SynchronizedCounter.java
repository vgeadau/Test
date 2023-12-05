package threads;

/**
 * Synchronized Counter uses {@link CounterThread} thread class.
 * @author Valentin
 */
public class SynchronizedCounter {
    public static void main(String[] args) throws InterruptedException {
        final long t1 = System.currentTimeMillis();
        // Instance of Counter Class
        Counter c = new Counter();

        // Defining Two different threads
        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        // Threads start executing
        first.start();
        second.start();

        // main thread will wait for both
        // threads to complete execution
        first.join();
        second.join();

        // Printing final value of count variable
        System.out.println(c.count);
        final long t2 = System.currentTimeMillis();
        System.out.println("It took " + (t2 - t1) + " milliseconds.");
    }
}