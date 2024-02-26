package threads;

import java.util.concurrent.Semaphore;

/**
 * Semaphore's shared resource class.
 * @author Valentin
 */
class SharedResource {
    private static final int MAX_AVAILABLE = 3;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

    public void useResource() {
        try {
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " is using the resource.");
            // Simulate some work being done with the resource
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // handle error if needed
        } finally {
            semaphore.release(); // Release the permit
            System.out.println(Thread.currentThread().getName() + " released the resource.");
        }
    }
}

/**
 * Thread implementation using the shared resource.
 * @author Valentin
 */
class MyThread extends Thread {
    private final SharedResource sharedResource;

    public MyThread(SharedResource sharedResource, String name) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.useResource();
    }
}

/**
 * Semaphore example.
 * 5 threads attempts to access a resource witch can be acquired only by 3 threads at a time.
 */
public class SemaphoreExample {

    /**
     * main method.
     * @param args String array
     */
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Create multiple threads trying to use the shared resource
        for (int i = 1; i <= 5; i++) {
            Thread thread = new MyThread(sharedResource, "Thread-" + i);
            thread.start();
        }
    }
}