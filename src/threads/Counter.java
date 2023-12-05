package threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread with a AtomicInteger counter.
 * @author Valentin
 */
class Counter extends Thread {

    // Atomic counter Variable
    AtomicInteger count;

    // Constructor of class
    Counter() {
        count = new AtomicInteger();
    }

    // method which would be called upon
    // the start of execution of a thread
    public void run() {

        int max = 100_000_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}