package threads;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBoolean example.
 * We obtain similar results as volatile example.
 * If we need to make sure that only after first thread finished execution the second start, we could use join.
 */
public class AtomicBooleanExample {
    /**
     * resource used by the threads.
     */
    private static final AtomicBoolean flag = new AtomicBoolean(false);

    /**
     * main method.
     * @param args String array
     */
    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread: Setting flag to true");
            flag.compareAndSet(false, true);
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                // handle error if needed
            }
            System.out.println("Writer thread: Finished");
        });

        Thread readerThread = new Thread(() -> {
            int attempts = 0;
            while (!flag.get()) {
                // Wait for the flag to become true
                attempts++;
            }
            System.out.println(attempts + " to break out of the infinite loop");
            System.out.println("Reader thread: Detected flag is true");
        });

        // starting of threads.
        writerThread.start();
        try {
            writerThread.join();
        } catch (InterruptedException ie) {
            // handle if needed;
        }
        readerThread.start();
        try {
            readerThread.join();
        } catch (InterruptedException ie) {
            // handle if needed;
        }

    }
}
