package threads;

/**
 * Test Thread.
 * The threads are executed asynchronously. The main, however since my thread isn't daemon thread
 * the message regarding the process "Process finished with exit code 0" will only be displayed after
 * finishing the execution.
 * If we set myThread as daemon thread:
 * the main thread does not wait for the new thread to finish, and the program may terminate even if
 * the new thread is still running.
 * @author Valentin
 */
public class TestThread {
    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("New Thread: " + i);
                try {
                    Thread.sleep(500); // Simulate some work
                } catch (InterruptedException e) {
                    // handle if needed
                }
            }
            System.out.println("New Thread: Finished");
        });

        // -> myThread.setDaemon(true); // Set the new thread as a daemon thread.
        // -> if we set this thread as Daemon, process will finish before myThread starts displaying
        myThread.start(); // Start the new thread

        // -> try {
        // ->     myThread.join(); // Wait for the new thread to finish
        // -> } catch (InterruptedException e) {
        // ->     // handle if needed
        // -> }

        System.out.println("Main Thread: Program ending");
    }
}
