package threads;

/**
 * Counter Thread with synchronized run method.
 * @author Valentin
 */
class CounterThread extends Thread {

    // Counter Variable
    int count = 0;

    // method which would be called upon
    // the start of execution of a thread
    public synchronized void run() {
        int max = 100_000_000;

        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count++;
        }
    }
}