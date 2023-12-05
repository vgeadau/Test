package threads;

/**
 * Race condition example.
 * @author Valentin
 */
public class RaceConditionExample {
    private static int counter = 0;

    public static void main(String[] args) {
        // Creating two threads that increment the counter concurrently
        Thread thread1 = new Thread(() -> {
            //to fix race condition add -> synchronized (RaceConditionExample.class) {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            //}
        });

        Thread thread2 = new Thread(() -> {
            //to fix race condition add -> synchronized (RaceConditionExample.class) {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            //}
        });

        // Starting both threads
        thread1.start();
        thread2.start();

        // Waiting for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // handle error if needed
        }

        // Displaying the final value of the counter
        System.out.println("Final Counter Value: " + counter);
    }
}