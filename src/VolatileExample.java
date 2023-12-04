/**
 * Volatile Example
 * -------------------------------------------------------------------------------------------
 * What is volatile?
 * -------------------------------------------------------------------------------------------
 * volatile keyword indicates that a variable may be changed by multiple threads.
 * it also insures that changes are visible to other threads immediately.
 * NOTA BENE! It doesn't provide atomicity for compound actions (incrementing a counter).
 * So in other words, volatile is also recommended for flags or status updates.
 * For more complex scenarios atomic variables should be used or synchronized.
 * -------------------------------------------------------------------------------------------
 * What is happening?
 * -------------------------------------------------------------------------------------------
 * writerThreads updates flag to true.
 * this change is reflected immediately on readerThread as it waits for writerThread to set flag to true.
 * Notice that although starting of both threads took under 1 millisecond, it takes around 6 milliseconds
 * for the flag to be perceived as true in the reading thread. So this change doesn't happen instantly.
 * Without usage of System.currentTimeMillis() it takes around 10K attempts to break out the while loop.
 * @author Valentin
 */
public class VolatileExample {
    /**
     * resource used by the threads.
     */
    private static volatile boolean flag = false;

    /**
     * long variables used for checking duration
     */
    private static long t1 = 0L;
    private static long t2 = 0L;

    /**
     * main method.
     * @param args String array
     */
    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread: Setting flag to true");
            flag = true;
            t1 = System.currentTimeMillis();
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                // handle error if needed
            }
            System.out.println("Writer thread: Finished");
        });

        Thread readerThread = new Thread(() -> {
            int attempts = 0;
            while (!flag) {
                // Wait for the flag to become true
                attempts++;
            }
            t2 = System.currentTimeMillis();
            System.out.println("It took " + (t2 - t1) + " milliseconds for change to be reflected to reader thread.");
            System.out.println(attempts + " to break out of the infinite loop");
            System.out.println("Reader thread: Detected flag is true");
        });

        // starting of writing thread.
        long t3 = System.currentTimeMillis();
        writerThread.start();
        long t4 = System.currentTimeMillis();
        System.out.println("It took " + (t4 - t3) + " milliseconds for starting writing thread.");

        t3 = System.currentTimeMillis();
        readerThread.start();
        t4 = System.currentTimeMillis();
        System.out.println("It took " + (t4 - t3) + " milliseconds for starting reading thread.");
    }
}